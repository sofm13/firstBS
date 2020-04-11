using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Word = Microsoft.Office.Interop.Word;
namespace Word2010AddIn1
{

    public class TableAnalysizeTool
    {
        private string getCellContent(Word.Cell vCell)
        {
            return vCell.Range.Text.Trim().Replace("\r\a", "").Replace(" ", "").Replace("\r", "").Replace("\a", "");//表格中内部内容的换行，不一定都是\r\a ，非最后一行是\r
        }
       
        private Word.Table mTable = null;
        private int maxColNum = 0, maxRowNum = 0;
        public CellInfo[,] allCellInfo;//开发给 FillTool用,暂时没怎么用.以后再说.
        public void ResetByWordTable(Word.Table vTable)
        {
            mTable = vTable;
            maxColNum = mTable.Columns.Count;
            maxRowNum = mTable.Rows.Count;
            //if (allCellInfo != null) allCellInfo.dispose(); TO_DO:数组使用后如何销毁，因为C#中总是用new来创建对象！ 一个数组变量需要多次实例化，该如何销毁（析构）？
            allCellInfo = new CellInfo[maxRowNum + 1, maxColNum + 1];
            for (int i = 1; i <= maxRowNum; i++)
                for (int j = 1; j <= maxColNum; j++)
                {
                    allCellInfo[i, j].cellType = CellType.none;
                    allCellInfo[i, j].hasWord = false;//无法对结构体在定义时进行字段的初始化
                    allCellInfo[i, j].cellWidth = -1;
                    allCellInfo[i, j].cellLeft = -1;
                }
        }
        public TableAnalysizeTool(Word.Table vTable)
        {
            ResetByWordTable(vTable);

        }
        private int getRowLastCellColumIndex(int vRowNum, int endIndex = -1)//TO_DO:对于子段的计算待完成，会比较复杂，因为不是矩阵上的矩形块！子段的范围中，每一行的起始值都不一样！！尽管列数相等。
        {
            int result = 1;
            for (int j = 1; j <= maxColNum; j++)
            {
                if (allCellInfo[vRowNum, j].cellType != CellType.none)
                {
                    result = j;
                }
            }
            return result;
        }
        //只能判断
        private int rowHasMergedColumn(int vRowNum, int vColBeginIndex)//从vColBeginIndex开始扫描，返回第一个mergeColumn的index，否则返回0
        {
            int result = 0;
            int noneBegin = 0, uncertainBegin = 0, uncertainEnd = 0;
            for (int j = vColBeginIndex; j <= maxColNum; j++)//算法：只要none的开始和uncertain的结束不一致就是非卡片。2015年5月2日：太绝对！如果本行的有效column是连续的就没有事情。
            {
                if (allCellInfo[vRowNum, j].cellType == CellType.none)
                {
                    if (noneBegin == 0) noneBegin = j;
                }
                else if (allCellInfo[vRowNum, j].cellType == CellType.uncertain)
                {
                    if (j > uncertainEnd) uncertainEnd = j;
                    if (uncertainBegin == 0) uncertainBegin = j;
                }
            }
            if ((noneBegin != 0) && ((uncertainBegin < noneBegin) && (uncertainEnd > noneBegin)))// (uncertainBegin + 1 != noneBegin))改为 无效格出现在有效格index的中间 
            {
                result = noneBegin;
                return result;
            }
            return result;
        }
        /*
         * 功能:判断某行的第一格合并了下面的多少行(包括自身行)。如果要判断任意格是否合并了下面的行会困难些，因为各行的同列格的index不同，只能采用“宽度”测量法。
         * 算法：该行下面的各行第一格，或者与本第一个cell左边对其的第一个列序号在行中是空缺的。
         * 应用说明，这是判断纵向list段的第一步，是judgeMultiRowIsListMode 的子函数。
         */
        private int firstCellMergedColumns(int vRowNum, int vColBeginIndex)//从vColBeginIndex开始扫描，判断第一格cell是否为merged。返回 merged的行数
        {
            int result = 1;//主题所在的行,下面是计算其他行的第一列
            if (vColBeginIndex == 1) //直接判断下面的行是否存在第一列
            {
                for (int i = vRowNum + 1; i <= maxRowNum; i++)
                {
                    if (allCellInfo[i, 1].cellType == CellType.none) result++;
                    else break;
                }
            }
            return result;
        }

        /*功能：判断某行为主题式提示语，也就是就整行就一个提示语单元格，无空格
         * vColBeginIndex参数是为了后续复杂混合段中的应用而增加的
         */
        private bool rowIswholeMerged(int vRowNum, int vColBeginIndex = 1)
        {
            int hintCellCount = 0;
            int emptyCellCount = 0;

            for (int j = vColBeginIndex; j <= maxColNum; j++)
            {
                if ((allCellInfo[vRowNum, j].cellType == CellType.uncertain) && (allCellInfo[vRowNum, j].hasWord)) hintCellCount++;
                if ((allCellInfo[vRowNum, j].cellType == CellType.uncertain) && (!allCellInfo[vRowNum, j].hasWord)) emptyCellCount++;
                if ((emptyCellCount > 0) || (hintCellCount > 1)) break;

            }
            return (hintCellCount == 1) && (emptyCellCount == 0);
        }
        /*
         * 功能：从某个columnIndex开始后面是否全为提示语，也就是列表式段的依据。
         */
        private bool rowIsAllHintCell(int vRowNum, int vColBeginIndex)
        {
            bool result = true;
            for (int j = vColBeginIndex; j <= maxColNum; j++)
            {
                if ((allCellInfo[vRowNum, j].cellType == CellType.uncertain) && (!allCellInfo[vRowNum, j].hasWord))
                {
                    result = false;
                    break;
                }
            }
            return result;
        }

        /*
        * 功能：从某个columnIndex开始后面是否全为空格，并返回空格个数。
        */
        private bool rowIsAllEmptyCell(int vRowNum, int vColBeginIndex, ref int vEmptyCellcount)
        {
            bool result = true;
            vEmptyCellcount = 0;
            for (int j = vColBeginIndex; j <= maxColNum; j++)
            {
                if ((allCellInfo[vRowNum, j].cellType == CellType.uncertain) && (!allCellInfo[vRowNum, j].hasWord))
                {
                    vEmptyCellcount++;
                }
                if ((allCellInfo[vRowNum, j].cellType == CellType.uncertain) && (allCellInfo[vRowNum, j].hasWord))
                {
                    result = false;
                    break;
                }
            }
            return result;
        }
        /*
         * 功能：从某个columnIndex开始整行具有的提示语cell数量。
         */
        private int rowHintCellCount(int vRowNum, int vColBeginIndex)
        {
            int result = 0;
            for (int j = vColBeginIndex; j <= maxColNum; j++)
            {
                if ((allCellInfo[vRowNum, j].cellType == CellType.uncertain) && (allCellInfo[vRowNum, j].hasWord))
                {
                    result++;
                }
            }
            return result;
        }
        /*
         从第X行的第X列开始扫描
         * isSegmentFirstRow：表示是否是扫的段的第一行。第一行不能出现列号不连续的情况！其他行可能，只要出现不连续，那么该行就不是简单卡片。
         */
        private bool judgeSimpleRowIsCardMode(int vRowNum, int vColBeginIndex, bool isSegmentFirstRow = true)
        {
            bool result = true;
            //判断标准：如果不是第一行，需要直接计算有效的列号是否连续。不需要！同标准续的原因。
            //判断标准1：是否为连续的“属性+属性值”模式，即“提示语+空格模式”；
            //判断标准续：下一行的列号也是连续的，不管有多少列。否则此行某列决定了下一行某（些）列。该标准要求不合理，被剔除了。因为一旦出现这种情况，就是混合模式了，不可能是单纯的“属性+属性值”。
            /* if (!isSegmentFirstRow)
             {
                 if (rowHasMergedColumn(vRowNum, vColBeginIndex)>0) 
                 {
                     result = false;
                     return result;
                 }  
             }*/
            int colMax = getRowLastCellColumIndex(vRowNum);//如果用maxColNum对下面的判断会更加复杂,要考虑最后一列是提示语,而后面没有的情况
            for (int j = vColBeginIndex; j <= colMax; j++)
            {
                if (j == colMax) break;//最后一格无论是什么都算卡式行了
                else
                {
                    /*
                     * //无需扫描到最后,遇到无此格就停下,这可能是不对的,如果遇到有合并格的行,就误判了!
                        if ((allCellInfo[vRowNum, j].cellType == CellType.none) || (allCellInfo[vRowNum, j + 1].cellType == CellType.none))
                        {
                            //单元格的类型只能在判明了段类型后才能确定 if (allCellInfo[vRowNum, j].hasWord) allCellInfo[vRowNum, j].cellType = CellType.hint;//！！！可以考虑为omit类型
                            break;
                        }
                        else*/
                    if (!((allCellInfo[vRowNum, j].hasWord) && !(allCellInfo[vRowNum, j + 1].hasWord)))
                    {
                        result = false;
                        return result;
                    }
                }
                j++;
            }
            //继续判断 应该不需要，除非表格不规范。
            if (vRowNum < maxRowNum)
            {
                for (int j = vColBeginIndex; j <= colMax; j++)
                {
                    // if (j<maxColNum)
                }
            }
            return result;
        }

        //某行为简单卡片式时，填充本行单元格的具体信息。
        private void fillSimpleCardModeRowWithCellInfo(int vRowNum, int vColBeginIndex)//
        {
            for (int j = vColBeginIndex; j <= maxColNum; j++)
            {
                if (allCellInfo[vRowNum, j].cellType == CellType.uncertain)
                    if (allCellInfo[vRowNum, j].hasWord)
                    {
                        if (j == maxColNum) allCellInfo[vRowNum, j].cellType = CellType.omit;//最后一列可以考虑为omit类型
                        else allCellInfo[vRowNum, j].cellType = CellType.hint;
                        //11 if ((j < maxColNum)) && ())
                        if ((j < maxColNum) && (allCellInfo[vRowNum, j + 1].cellType == CellType.uncertain))//不是最后一列的话,就有待填写的目标单元格
                        {
                            allCellInfo[vRowNum, j].targetCell.x = vRowNum;
                            allCellInfo[vRowNum, j].targetCell.y = j + 1;
                        }
                    }
                    else allCellInfo[vRowNum, j].cellType = CellType.empty;
            }
            //else 其他类型的无需处理，多数为none，部分为invalid
        }

        //某行从某列开始为列表段的提示语时，填充本行单元格的具体信息。
        private void fillListModeBodyCellInfo(int vRowBeginIndex, int vRowEndIndex, int vColBeginIndex)//
        {
            for (int i = vRowBeginIndex; i <= vRowEndIndex; i++)
                for (int j = vColBeginIndex; j <= maxColNum; j++)
                {
                    if (allCellInfo[i, j].cellType == CellType.uncertain)
                        if (allCellInfo[i, j].hasWord)
                        {
                            allCellInfo[i, j].cellType = CellType.hint;//！可以考虑为omit类型
                            allCellInfo[i, j].targetCell.x = i + 1;
                            allCellInfo[i, j].targetCell.y = j;
                        }
                        else allCellInfo[i, j].cellType = CellType.empty;
                }
        }

        /*
        * 从第X行的第X列开始扫描
        * 目前本行已经不是card模式了，那么就要确定list段的范围。
        * ref int rowCount返回列表式段的行数
        *         simpleHorizontalList = 2,//无主题简单列表式（横向）
        *         simpleVerticalList = 3,//无主题简单列表式（纵向）
        *         simpleHorizontalListWithSubject = 4,//有主题的简单列表（横向）
        *         simpleVerticalListWithSubject = 5,//有主题的简单列表（横向）
        */
        private bool judgeMultiRowIsListMode(int vRowNum, ref int vRowCount, ref SegmentType vSegmentType, bool isSegmentFirstRow = true, int vColBeginIndex = 1)
        {
            vSegmentType = SegmentType.uncertain;
            bool result = false;
            int aVerticalSubjectColumBeginIndex = 2;//纵向有主题的提示语和空格去从第2列开始判断          纵向无主题的暂不考虑!
            int aHorizontalColumBeginIndex = 1;//横向有/无主题的提示语和空格去 均 从第1列开始判断
            //参照表的格式来设计算法。
            //判断标准1：第一格是个合并格，及主题，然后第一行均有提示语。进而通过第一格merged的行数确定范围；
            //判断标准2：第一行均为提示语，没有主题

            if ((firstCellMergedColumns(vRowNum, 1) == 1) && (rowIsAllHintCell(vRowNum, aHorizontalColumBeginIndex)) && (rowHintCellCount(vRowNum, aHorizontalColumBeginIndex) > 1))//初步为无主题的横向list模式;不考虑嵌套、分组等报表结构  TO_DO:组号HintCell>1,否则成纵向卡片了!
            {
                vSegmentType = SegmentType.simpleHorizontalList;
                //通过判断下面的空格行数来确定范围
                int hintCellCount = rowHintCellCount(vRowNum, aHorizontalColumBeginIndex);
                int aEmptyCellCount = 0;
                vRowCount = 1;//属性行占了1行
                for (int i = vRowNum + 1; i <= maxRowNum; i++)
                {//判断是否全空格及空格的个数
                    if (rowIsAllEmptyCell(i, aHorizontalColumBeginIndex, ref aEmptyCellCount))
                    {
                        if (aEmptyCellCount != hintCellCount)
                        {
                            //result = false;
                            break;
                        }
                        else vRowCount++;
                    }
                    else break;
                }
                if (vRowCount >= 2) result = true;//最好是>2，列表的话至少留2行空格行            
            }
            else if ((firstCellMergedColumns(vRowNum, 1) > 1) && (rowIsAllHintCell(vRowNum, aVerticalSubjectColumBeginIndex)))//初步为纵向主题的横向list模式;不考虑嵌套、分组等报表结构
            {
                vSegmentType = SegmentType.simpleVerticalListWithSubject;
                result = false;
                int hintCellRowIndex = vRowNum;
                int emptyCellStartRowIndex = vRowNum + 1;
                //通过判断下面的空格行数来确定范围
                int hintCellCount = rowHintCellCount(hintCellRowIndex, aVerticalSubjectColumBeginIndex);
                int rowMergeCount = firstCellMergedColumns(vRowNum, 1);//包括主题/属性行在内
                int aEmptyCellCount = 0;
                int endRowIndex = vRowNum + rowMergeCount - 1;
                vRowCount = 1;
                for (int i = emptyCellStartRowIndex; i <= endRowIndex; i++)
                {//判断是否全空格及空格的个数与提示语的数量相等
                    if (rowIsAllEmptyCell(i, aVerticalSubjectColumBeginIndex, ref aEmptyCellCount))
                    {
                        if (aEmptyCellCount != hintCellCount)
                        {
                            result = false;
                            break;
                        }
                        else vRowCount++;
                    }
                    else
                    {
                        result = false;
                        break;
                    }
                }
                result = vRowCount == rowMergeCount;

            }
            else if ((rowIswholeMerged(vRowNum, 1)) && (rowIsAllHintCell(vRowNum + 1, aHorizontalColumBeginIndex)) && (rowHintCellCount(vRowNum + 1, aHorizontalColumBeginIndex) > 1))//初步为横向主题的横向列表模式 TO_DO:暂不考虑有什么“合计”cell带来的影响。
            {
                vSegmentType = SegmentType.simpleHorizontalListWithSubject;
                int hintCellRowIndex = vRowNum + 1;
                int empthCellStartRowIndex = vRowNum + 2;
                //如果表本身不是单列的话，应该就是横向列表式。是否可能就是纵向卡片式的呢？？？通常不考虑纵向卡片，而考虑横向卡片。
                //通过判断下面的空格行数来确定
                int hintCellCount = rowHintCellCount(hintCellRowIndex, aHorizontalColumBeginIndex);
                int aEmptyCellCount = 0;
                vRowCount = 2;
                result = false;
                for (int i = empthCellStartRowIndex; i <= maxRowNum; i++)
                {//判断是否全空格及空格的个数
                    if (rowIsAllEmptyCell(i, aHorizontalColumBeginIndex, ref aEmptyCellCount))
                    {
                        if (aEmptyCellCount != hintCellCount)
                        {
                            //result = false;
                            break;
                        }
                        else vRowCount++;
                    }
                    else break;
                }
                if (vRowCount >= 3) result = true;//最好是>3，列表的话至少留2行空格行
            }
            else//其他类型,如交叉表,主从表等,日后再说.
            {
                if (isSegmentFirstRow && (vColBeginIndex == 1))//对交叉表的特殊处理
                {
                    if (!allCellInfo[vRowNum, vColBeginIndex].hasWord)//忽略前面的空格，可能的表格比较复杂？就是表X型。第一格带有斜线的那种。那这就是横向或纵向列表式的了。 TO_DO
                    {
                    }
                }
            }
            return result;
        }
        public bool cutTableToSegment(List<TableSegment> TS)
        {
            //分割成功就可以对分割后的segments进行处理了
            bool result = false;

            Word.Cells tableCells = mTable.Range.Cells;
            //判断每行的最大列号是否都相等； 判断每列的最大行号是否都相等。
            int maxColNum = 0, maxRowNum = 0;
            maxColNum = mTable.Columns.Count;
            maxRowNum = mTable.Rows.Count;
            //           Word.Columns allColumns = aTable.Columns;//有合并cell时，无法对columns进行遍历。下面的方法会报错，已屏蔽。
            //            foreach (Word.Column aCol in allColumns)//无法访问此集合中单独的列，因为表格有混合的单元格宽度。
            string aContentHint;
            //1.先分割为行？不行！会有合并格。但是还是可以的，且必须这样。
            Word.Cell nextCell = tableCells[1], acell;
            //int rowIndex=1, colIndex = 1;
            int currentRowIndex = 1;
            float cellLeftValue = 0.0f;//记录单元格的左侧位置值，便于后面判断……？？？
            for (int i = 1; i <= tableCells.Count; i++)//第一遍扫描后，存在的格子都是暂未定，只有后面进行段分析才能真正确定类型
            {
                acell = tableCells[i];
                aContentHint = getCellContent(acell);
                if (currentRowIndex != acell.RowIndex)
                {
                    cellLeftValue = 0.0f;
                    currentRowIndex = acell.RowIndex;
                }
                allCellInfo[acell.RowIndex, acell.ColumnIndex].cellType = CellType.uncertain;
                allCellInfo[acell.RowIndex, acell.ColumnIndex].hasWord = !aContentHint.Equals("");
                allCellInfo[acell.RowIndex, acell.ColumnIndex].hintWord = aContentHint;
                allCellInfo[acell.RowIndex, acell.ColumnIndex].cellWidth = acell.Width;
                allCellInfo[acell.RowIndex, acell.ColumnIndex].cellLeft = cellLeftValue;
                cellLeftValue += acell.Width;
            }

            // 开始对表格进行分段
            //CellInfo aCellInfo;

            SegmentType aSegmentType = SegmentType.uncertain;
            for (int i = 1; i <= maxRowNum; i++)
            {
                //后续考虑！分段就是逐行扫描，无需逐格扫描
                int j = 1;
                // for (int j = 1; j <= maxColNum ; j++)
                {
                    //                    aCellInfo = allCellInfo[i, j];
                    //第一步：假设段为横向卡片 整行扫描均符合“属性+属性值”模式                    
                    int aListSegmentRowCount = 0;
                    //段的起始行已经记录在range中了。
                    if ((!rowIswholeMerged(i, 1)) && (judgeSimpleRowIsCardMode(i, j, true)))
                    { //应该是个复杂的递归才对，这样用分支判断有难度。
                        TableSegment aTS = new TableSegment();
                        TS.Add(aTS);
                        //后面分析时才能确定 aCellInfo.cellType = CellType.hint;
                        aTS.range.beginPos.x = i;
                        aTS.range.beginPos.y = 1;
                        //试图找到最多的行即可 
                        int lastCardModeRowIndex = 0;
                        i++;
                        //TO_DO 可以考虑去掉前面的空格。
                        while ((i <= maxRowNum))
                        {
                            if (judgeSimpleRowIsCardMode(i, 1, false))
                            {
                                lastCardModeRowIndex = i;
                                i++;
                            }
                            else
                            {
                                break;
                            }
                        }
                        i = lastCardModeRowIndex;
                        for (int ii = aTS.range.beginPos.x; ii <= lastCardModeRowIndex; ii++)
                            fillSimpleCardModeRowWithCellInfo(ii, 1);
                        aTS.sType = SegmentType.simpleCard;
                        aTS.hasSubSegment = false;
                        aTS.range.endPos.x = lastCardModeRowIndex;
                        aTS.range.endPos.y = getRowLastCellColumIndex(lastCardModeRowIndex);//和beginPos.y的值无关系，可能大于也可能小于。其实是无意义的值？如果是混合段内，则有意义。
                        //subject
                        //将allcellinfo中的相关内容填入 aTS的list<cellInfo>
                        aTS.fillCellInfo(allCellInfo, maxColNum);
                        //i--;
                    }
                    else if (judgeMultiRowIsListMode(i, ref aListSegmentRowCount, ref aSegmentType, true))// 判断是否为有主题的列表  aListSegmentRowCount：列表段的行数（包括主题或提示行本身）
                    {
                        TableSegment aTS = new TableSegment();
                        TS.Add(aTS);
                        //后面分析时才能确定 aCellInfo.cellType = CellType.hint;
                        aTS.range.beginPos.x = i;
                        aTS.range.beginPos.y = 1;
                        int bodyStartRowIndex = i;//如果有主题,后面会修改
                        int bodyStartColIndex = 1;//如果有主题,后面会修改
                        string aSubject = "";
                        if (aSegmentType == SegmentType.simpleHorizontalListWithSubject)
                        {//填充subject信息
                            //aTS.subject.sName = allCellInfo[bodyStartRowIndex, bodyStartColIndex].hintWord;
                            allCellInfo[bodyStartRowIndex, bodyStartColIndex].cellType = CellType.subject;
                            aSubject = allCellInfo[bodyStartRowIndex, bodyStartColIndex].hintWord;
                            bodyStartRowIndex++;
                        }
                        else if (aSegmentType == SegmentType.simpleVerticalListWithSubject)
                        {
                            allCellInfo[bodyStartRowIndex, bodyStartColIndex].cellType = CellType.subject;
                            aSubject = allCellInfo[bodyStartRowIndex, bodyStartColIndex].hintWord;
                            bodyStartColIndex++;
                        }
                        else { }//其他类型,均无需填其他项
                        aTS.sType = aSegmentType;
                        aTS.hasSubSegment = false;
                        aTS.subject.sName = aSubject;
                        //aTS.subject.sRange.beginPos
                        aTS.range.beginPos.x = i;
                        aTS.range.beginPos.y = 1;
                        aTS.range.endPos.x = i + aListSegmentRowCount - 1;
                        i = aTS.range.endPos.x;
                        aTS.range.endPos.y = getRowLastCellColumIndex(aTS.range.endPos.x);
                        fillListModeBodyCellInfo(aTS.range.beginPos.x, aTS.range.endPos.x, 1);
                        aTS.fillCellInfo(allCellInfo, maxColNum);

                    }
                    else// //遇到无效行了.无效行不需要创建相应的段;但是单元格还是要填上类型的
                    {
                        for (int jj = 1; jj < maxColNum; jj++)
                            if (allCellInfo[i, jj].cellType == CellType.uncertain) allCellInfo[i, jj].cellType = CellType.invalid;
                    }
                }
            }//end for

            return result;

        }
    }//end of TableAnalysizeTool
    
}

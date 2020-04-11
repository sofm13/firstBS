using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Word = Microsoft.Office.Interop.Word;
using System.Data;
using System.Data.OleDb;


namespace Word2010AddIn1
{

    public class TableFillTool
    {
        private Word.Table mTable;
        private List<TableSegment> mTSList;
        private int maxColNum = 0, maxRowNum = 0;
        private CellInfo[,] allCellInfo1;
        private FillMedadataTool mFillMedadataTool = null;        
        public TableFillTool()
        {
            mTSList = new List<TableSegment>();
            mTable = null;
            //mPublicPMetaData = new PropertyMedata();
            mFillMedadataTool = FillMedadataToolHelper.getFillMedadataTool();
        }
 
        //private PropertyMedata mPublicPMetaData = null;//用来临时存储单个hint单元格的填写元数据信息。在card中可直接使用，在list填写中也可使用，但是仍然需要内部建立新的list<PropertyMedata>
        public void setPropertyBeforeFill(Word.Table vTable, CellInfo[,] vCellInfos)
        {
            mTable = vTable;
            allCellInfo1 = vCellInfos;
            maxColNum = mTable.Columns.Count;
            maxRowNum = mTable.Rows.Count;

        }
        private void fillValueToTableCell(object value, CellPos vCellPos, int CellIndex)
        {
            Word.Cell aCell = mTable.Cell(vCellPos.x, vCellPos.y);
            if (value is string)
            {
                aCell.Range.Text = (string)value;
            }
        }
        private void fillErrorToTableCell(object value, CellPos vCellPos, int CellIndex)
        {
            Word.Cell aCell = mTable.Cell(vCellPos.x, vCellPos.y);
            if (value is string)
            {
                aCell.Range.Text = (string)value;
                aCell.Range.Font.Color = Microsoft.Office.Interop.Word.WdColor.wdColorRed;
                //背景色设置：考虑为入口参数 aCell.Range.
            }
        }
        private void fillSimpleCardTable(TableSegment vTS)
        {
            if (ThisAddIn.selfDebugMessage) System.Windows.Forms.MessageBox.Show("开始填写找到的简单表格");
            foreach (CellInfo aCellInfoToFill in vTS.cells)
            {
                if (aCellInfoToFill.cellType == CellType.hint)
                {
                    fillSingleCellWithCellInfo(aCellInfoToFill);
                }
            }
        }
        private bool fillSingleCellWithCellInfo(CellInfo vCellInfo)//卡片式属性的填空 vCellInfo指示为HintWord类型
        {
            
            string fillValue=string.Empty;
            try
            {
                //1.获取相应的填写元数据。结果暂时不存储在cellInfo中，如果以后会不断地用到则需要重新处理。目前是逐个单元格处理的方式，没有一次性为全部单元格获取相应的填写元数据信息。
                FillMedadata aPMetaData = mFillMedadataTool.getSingleFillMedadata(vCellInfo.hintWord);//返回的是引用吗？
                //2.获取相应的数据库值
                if (aPMetaData != null)
                {
                    fillValue = DBToolHelper.getDBTool().getSimpleValueByMetadata(aPMetaData);
                }
                //3. 填写目标格
                if (!(fillValue.Equals(string.Empty)))
                {
                    fillValueToTableCell(fillValue, vCellInfo.targetCell, -1);
                    return true;
                }
                else//改为红色“没有找到相应值”。
                {
                    fillErrorToTableCell("没有找到相应值", vCellInfo.targetCell, -1);
                    return false;
                }
            }
            catch
            {
                    //TO_DO: 单元格标红,表示识别不了!
                fillErrorToTableCell("没有找到相应值", vCellInfo.targetCell, -1);
                return false;
            }
        }

        //vAllHintCellInfo参数其实是蕴含在vTS，但是不能把这个分析工作交给被函数。而应该由调用者解决。
        //本函数仅仅依据……
        private bool fillMultiTableCellWithCellInfos(CellInfo[] vAllHintCellInfo, TableSegment vTS,ref int vTableNewRowCount)//list式属性的填空
        {
            const string invaildFieldName = "##########**********";
            FillMedadata mPublicPMetaData = new FillMedadata();
            //vTableNewRowCount = 0; 不能初始化为0,必须带入表格之前增减的行数!
            bool result = false;
            string[] aAllFieldName = new string[vAllHintCellInfo.Length];
            string aStrSQL="";
            string fillValue;
            try
            {
                //1. 设置每一个cellInfo对应的字段值，此时不能出现计算字段，必须
                //2. 根据每个字段值，构建select的 * 字句语句 
                //3. 因为没有主题，只能猜测主题（！！！！！）通过若干个属性共同的tablename元信息
                //4.根据主题等信息构建select的where字句
                result = true;
                for (int i = 0; i < vAllHintCellInfo.Length; i++)
                {
                    if (mPublicPMetaData.setProMetaInfoByString(vAllHintCellInfo[i].hintWord))
                    {
                        aAllFieldName[i] = mPublicPMetaData.proMetaName;
                    }
                    else//有部分字段无法识别该如何办?填能填的!!!好主意.
                    {
                        //                        break;
                        aAllFieldName[i] = invaildFieldName;
                        result = false;
                    }
                }
                //无论是否字段找的如何,部分还是全部都可以构建SQL语句
                //if (!aAllFieldName[i].Equals(invaildFieldName))//有效字段,加入sql语句
                aStrSQL = "select *  from BasicInfo";
                //假设语句已经构成

                OleDbDataReader aFillDataReader = DBToolHelper.getDBTool().getDataReaderBySQL(aStrSQL);
                int aFillRecordCount = 0;//aFillDataReader.Count;
                int aTableFillRowCount = vTS.range.endPos.x - vTS.range.beginPos.x - 1;//1为属性行,此内容应该作为vTS内部接口最好.使用者好用!
                CellPos aFillCellPos;
                while (aFillDataReader.Read())
                {
                    //1.视情况 增加行数.
                    aFillRecordCount++;
                    if (aFillRecordCount > aTableFillRowCount) 
                    {
                        //TO_DO:调用表格增加行的语句,如果是其他段模式,还要考虑主题合并的问题.
                        vTableNewRowCount++;
                    }
                    //2.确定目标空格cell,并填写
                    /*根据属性名*/
                    for (int i = 0; i < vAllHintCellInfo.Length; i++)
                    {
                        aFillCellPos.x = vAllHintCellInfo[i].targetCell.x + vTableNewRowCount;
                        aFillCellPos.y = vAllHintCellInfo[i].targetCell.y;
                        fillValue = "从数据库中找";
                        fillValueToTableCell(fillValue, aFillCellPos, -1);
                    }
                    
                }
                aFillDataReader.Close();
            }
            catch
            {
            }
            return result;
        }
        public bool fillTable(Word.Table vTargetTable)
        {
            TableAnalysizeTool aTableAnalysizeTool = null;
            aTableAnalysizeTool = new TableAnalysizeTool(vTargetTable);
            aTableAnalysizeTool.cutTableToSegment(mTSList);//同时获取所有的cell信息，allCellInfo

            setPropertyBeforeFill(vTargetTable, aTableAnalysizeTool.allCellInfo);

            return fillTableWithTableAndSegment();
        }
        private bool fillTableWithTableAndSegment()
        {
            /*算法基本思想:对aTS中的cells进行遍历逐个填 
             * 如果段类型为card 很简单,只要是hint类型的就填相应的目标.
             * 如果段为list,则需要考虑表格行数的增减,减可以忽略,但增有时是难避免的.
             */
            bool result = false;
            int aRowChanged = 0;//当有的list段增加了行数时，就会对后面的段进行填写时产生影响，用该变量记录行数的变化就能确保后面的填写的正确性。
            try
            {
                foreach (TableSegment aTS in mTSList)
                {
                    if (aTS.sType == SegmentType.simpleCard)//直接填写简单表格
                    {
                        fillSimpleCardTable(aTS);
                    }
                    else if (aTS.sType == SegmentType.simpleHorizontalList)
                    {
                        //需要通过查找得到多条记录,以教学信息为例子. 第一列均为属性
                        CellInfo[] aAllHintCellInfo = new CellInfo[aTS.range.endPos.y - aTS.range.beginPos.y + 1];
                        for (int j = 0; j < aAllHintCellInfo.Length; j++)
                        {
                            aAllHintCellInfo[j] = aTS.cells[j];
                        }
                        fillMultiTableCellWithCellInfos(aAllHintCellInfo, aTS, ref aRowChanged);

                        //可能需要扩展行数：①扩展表格增加行②修改aModifiedCellInfo③④

                    }
                    /* else if (aTS.sType == SegmentType.simpleHorizontalListWithSubject)
                     {
                         CellInfo[] aAllHintCellInfo = new CellInfo[vTS.range.endPos.y - vTS.range.beginPos.y];
                         fillMultiTableCellWithCellInfos(aTS);
                     }
                     else if (aTS.sType == SegmentType.simpleVerticalList)
                     {
                         CellInfo[] aAllHintCellInfo = new CellInfo[vTS.range.endPos.y - vTS.range.beginPos.y];
                         fillMultiTableCellWithCellInfos(aTS);
                     }
                     else if (aTS.sType == SegmentType.simpleVerticalListWithSubject)
                     {
                         CellInfo[] aAllHintCellInfo = new CellInfo[vTS.range.endPos.y - vTS.range.beginPos.y];
                          fillMultiTableCellWithCellInfos(aTS);
                     }*/

                }
                result = true;
            }
            catch
            {
               
            }
            return result;
        }

    }

}

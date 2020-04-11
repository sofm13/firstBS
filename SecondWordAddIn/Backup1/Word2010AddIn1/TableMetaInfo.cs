using System;
using System.Collections.Generic;

namespace Word2010AddIn1
{
    public enum SegmentType
    {
        simpleCard = 1,//简单卡片式（横向或纵向）
        simpleHorizontalList = 2,//无主题简单列表式（横向）
        simpleVerticalList = 3,//无主题简单列表式（纵向）
        simpleHorizontalListWithSubject = 4,//有主题的简单列表（横向）
        simpleVerticalListWithSubject = 5,//有主题的简单列表（横向）
        mix = 6,//混合型
        uncertain = 7
    }
    public enum CellType
    {
        hint=1,//提示语;
        empty=2,//空格
        invalid=3,//无效，不该出现在规范表中的内容
        omit=4, //忽略 每行末尾的内容？或者照片提示语？
        uncertain = 5,//暂未定。第一遍扫描原表后建立表格内容模型时设定的值，表示在矩阵中的某个元素对应的二维表中有该单元
        subject = 6,
        none = 0//无此空格 初始值，矩阵中无此单元格，被合并了
    }
    public struct CellPos
    {
        public int x, y;
    }
    public struct CellRange
    {
        public CellPos beginPos, endPos;
    }
    public struct CellInfo//用于存储本项目关心的单元格信息
    {
        public CellType cellType;//无法初始化=CellType.none;
        public bool hasWord;//=false;
        public string hintWord;
        public CellPos targetCell;//对应的属性值位置
        //public int cellIndexOfOriginalTable;//对应原始表格的单元索引值
        public float cellWidth;//单元格的宽度
        public float cellLeft;//单元格的left值
    }
    public struct Subject
    {//主题
        public string sName;
        public CellRange sRange;
    }
    public class TableSegment
    {
        /*cellPos（x,y:int）
        HintCell（hintword：string，cellPos）；
        cellRange：（beginPos，endPos：cellPos）；
        Segment（cellrange，type，HintCells，SubSegment：Segment[]，subject：string）；
        allSegments[1..n] of Segment
        */
        public CellRange range;
        public bool hasSubSegment;//是否有子段，否则就是独立段
        public List<TableSegment> subSegments;
        public Subject subject;
        public SegmentType sType;
        public List<CellInfo> cells;
        public TableSegment() {
            subSegments = new List<TableSegment>();
            cells = new List<CellInfo>();
            range.beginPos.x = 0;//表示没有确定
            range.endPos.x = 0;//表示没有确定
            sType = SegmentType.uncertain;
            //range = new CellRange();
           // subject = new Subject();
        }
        //根据段的range信息,把入口vSrcCellInfo中的信息复制到 cells成员中.
        public void fillCellInfo(CellInfo[,] vSrcCellInfo,int vMaxColumnIndex)
        {
            int bodyStartRowIndex = range.beginPos.x;
            int bodyStartColIndex = range.beginPos.y;
            CellInfo aTmpCellInfo;
            for (int i = bodyStartRowIndex; i <= range.endPos.x; i++)
                for (int j = bodyStartColIndex; j <= vMaxColumnIndex; j++)//range.endPos.y是无法控制其他行的,只能用vMaxColumnIndex
                {
                    if (vSrcCellInfo[i, j].cellType != CellType.none)//无效的,忽略的都保存住
                    {
                        aTmpCellInfo = vSrcCellInfo[i, j];
                        cells.Add(aTmpCellInfo);
                    }
                }
            //关于subject的基本 在外部已经设置 ,此处可以考虑设置range,当然如果无subSegment的话,主题的range意义不大.
        }
        ~TableSegment()
        {
            //
        }
            /* 错误	1	请不要重写 object.Finalize，而是提供一个析构函数。	

            protected override void Finalize()
            {
                try
                {
                // destructor imp1ementation
                }
                finally
                {
                            
                }
            }*/
      
          /*  private SegmentType getSegmentType(Word.Table aTable){

                return SegmentType.simpleCard;
        }*/
    }//end of TableSegment

}//end of namespace

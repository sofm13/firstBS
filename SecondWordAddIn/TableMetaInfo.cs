using System;
namespace Word2010AddIn1
{
    public enum tableType
    {
        simpleCard = 1,//简单卡片式
        simpleList =2,//简单列表式
        simpleListWithSubject = 3 ,//有主题的简单列表
        simpleTableWithMerge = 2,
        complexTable = 3,//只能分块处理，有许多特殊情况。需要总结分类。
        uncertainTable = 4
    }
    private struct CellPos {
        int x, y;
    }
    private struct CellRange {
        CellPos beginPos, endPos;
    }
    private struct HintCell {
        string hintWord;
        CellPos targetCell;//对应的属性值位置
    }
    private struct Subject
    {//主题
        string sName;
        CellRange sRange;  
    }
    private class TableSegment
    {
        /*cellPos（x,y:int）
        HintCell（hintword：string，cellPos）；
        cellRange：（beginPos，endPos：cellPos）；
        Segment（cellrange，type，HintCells，SubSegment：Segment[]，subject：string）；
        allSegments[1..n] of Segment
        */
        private CellRange range;
        private bool hasSubSegment;//是否有子段，否则就是独立段
        private int BeginRowNum, EndColumnNum;
        private List<TableSegment> subSegments;
        private string subject;

    }
}

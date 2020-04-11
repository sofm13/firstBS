using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using Word = Microsoft.Office.Interop.Word;
using Office = Microsoft.Office.Core;
using Microsoft.Office.Tools.Word;
using Tools = Microsoft.Office.Tools;
using tableType = Word2010AddIn1.SegmentType;

namespace Word2010AddIn1
{
    public partial class ThisAddIn
    {
        public static bool selfDebugMessage = true;
        private Microsoft.Office.Tools.Word.Controls.Button button = null;//Controls引用自 Word.v4.0.Utilities.dll  vs2010中需要添加该引用
        internal Tools.CustomTaskPane myTableAssiantPanel = null;
        internal void ToggleCheckbox() {
            Document vstoDocument = Globals.Factory.GetVstoObject(this.Application.ActiveDocument);
            string name = "Mybutton";
            if (Globals.Ribbons.RibbonWord2010.addButtonCheckBox.Checked)
            {
                Word.Selection selection = this.Application.Selection;
                if (selection != null && selection.Range != null)
                {
                    button = vstoDocument.Controls.AddButton(selection.Range, 100, 30, name);
                }
            }
            else
            {
                vstoDocument.Controls.Remove(name);
            }
        }
             


        internal bool fillFirstWordTable()//如果要填写用户选定的表，则需要其他接口。
        {
            //1.获取word中的Table
            //2.将第一个Table交给tableFillTools进行处理
                       
            Document vstoDocument = Globals.Factory.GetVstoObject(this.Application.ActiveDocument);
            if (vstoDocument.Tables.Count > 0)
            {
                Word.Table targetTable = this.Application.ActiveDocument.Tables[1];
                TableFillTool aTableFillTool = null; 

                aTableFillTool = new TableFillTool();
                return aTableFillTool.fillTable(targetTable);
                

                /* Word.Range r1 = targetTable.Range;
                Word.Cells tableCells = r1.Cells;
                //以下测试：显示每个单元的行列号值，以观察word对复杂表格（有合并单元格的表格）的逻辑编码规则。\n
               foreach (Word.Cell aCell in tableCells)
                {
                    aCell.Range.Text = aCell.Range.Text + "(" + aCell.RowIndex.ToString() + ":" + aCell.ColumnIndex.ToString() + ")";
                    aCell.Range.Text = aCell.Range.Text + aCell.Width.ToString() + "/ " + aCell.Height.ToString();// +aCell.Width.ToString();
                }
                return;*/

            }
            return false;
        }
        private void myTableAssiantPanel_VisibleChanged(object sender, EventArgs e)
        {
            //疑问：发生的时机不符合逻辑。1、创建实例时触发了；2、关闭时不触发，显示时也不触发；所以基本上可以判断是该用户控件是嵌入在父窗体——某个custom panel上的。关闭和显示的是父窗体？但是在togglebutton中控制的还是本实例！
           // MessageBox.Show("test", "测试", MessageBoxButtons.OK, MessageBoxIcon.Information, MessageBoxDefaultButton.Button1);
            //TO_DO：遍历Ribbon，及其内部的group等
            //if (Globals.ThisAddIn.myTableAssiant != null)
            //    Globals.Ribbons.GetRibbon<RibbonWord2010>().tbgTableAssiant.Checked = Globals.ThisAddIn.myTableAssiant.Visible;
            //RibbonWord2010 myRibbon = Tools.Ribbon.RibbonManager.Equals
            Globals.Ribbons.RibbonWord2010.tbgTableAssiant.Checked = myTableAssiantPanel.Visible;
        }
        public Tools.CustomTaskPane tablePane {
            get
            {
                return myTableAssiantPanel;
            }
        }
        private void ThisAddIn_Startup(object sender, System.EventArgs e)
        {
           //1. 添加文件关闭时的资源释放处理。
            this.Application.DocumentBeforeSave += new Word.ApplicationEvents4_DocumentBeforeSaveEventHandler(Application_DocumentBeforeSave);
           //这是vs2008的代码 Word.Document nativeDocument = Globals.ThisAddIn.Application.ActiveDocument;
            //这是vs2008的代码 Document vstoDocument = nativeDocument.GetVstoObject();
            //2.创建侧边栏
            myTableAssiantPanel = this.CustomTaskPanes.Add(new TableAssiant(), "智能填表辅助");
            myTableAssiantPanel.Visible = false;
            myTableAssiantPanel.VisibleChanged += new EventHandler(myTableAssiantPanel_VisibleChanged);
            Globals.Ribbons.RibbonWord2010.tbgTableAssiant.Checked = myTableAssiantPanel.Visible;//保持一致性

        }

        private void ThisAddIn_Shutdown(object sender, System.EventArgs e)
        {
           // if (myTableAssiant != null) myTableAssiant.Dispose();//2015-04-28 似乎不需要，c#有垃圾收集器。
        }

        void Application_DocumentBeforeSave(Word.Document Doc, ref bool SaveAsUI, ref bool Cancel)
        {
            //已通过测试（出现了两次，可能是调试的原因） Doc.Paragraphs[1].Range.InsertParagraphBefore();//尽管语言的数组都从0开始计数，但word模型中的多数数组类型都是从1开始计数。
            //已通过测试（出现了两次，可能是调试的原因）  Doc.Paragraphs[1].Range.Text = "This text was added by using code.";
            //1. 以下是清除文档中用户添加的按钮！
            bool isExtended = Globals.Factory.HasVstoObject(Doc);
            if (isExtended) {
                Microsoft.Office.Tools.Word.Document vstoDocument = Globals.Factory.GetVstoObject(Doc);
                if (vstoDocument.Controls.Contains(button)) {
                    vstoDocument.Controls.Remove(button);
                    Globals.Ribbons.RibbonWord2010.addButtonCheckBox.Checked = false;
                }
            }

        }

        #region VSTO generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InternalStartup()
        {
            this.Startup += new System.EventHandler(ThisAddIn_Startup);//事件、委托技术，感觉还是函数指针。当然是可以多个函数被同时委托的要复杂得多。
            //相关的编程思想还是很关键的，扩展性，复用性等。可参考下载的“C#委托_百度百科.htm”
            this.Shutdown += new System.EventHandler(ThisAddIn_Shutdown);
        }
        
        #endregion
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using Word = Microsoft.Office.Interop.Word;
using Office = Microsoft.Office.Core;
using Microsoft.Office.Tools.Word;

namespace SecondWordAddIn
{
    public partial class ThisAddIn
    {
        //private Microsoft.Office.Tools.Word.Controls.Button button = null;
        void Application_DocumentBeforeSave(Word.Document Doc, ref bool SaveAsUI, ref bool Cancel) 
        {
            Doc.Paragraphs[1].Range.InsertParagraphBefore();//尽管语言的数组都从0开始计数，但word模型中的多数数组类型都是从1开始计数。
            Doc.Paragraphs[1].Range.Text = "This text was added by using code.";
        }
        private void ThisAddIn_Startup(object sender, System.EventArgs e)
        {
            //this.Application.DocumentBeforeSave += new Word.ApplicationEvents4_DocumentBeforeSaveEventHandler(Application_DocumentBeforeSave);

            Word.Document nativeDocument = Globals.ThisAddIn.Application.ActiveDocument;

            //Document vstoDocument = nativeDocument.get;
        }

        private void ThisAddIn_Shutdown(object sender, System.EventArgs e)
        {
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

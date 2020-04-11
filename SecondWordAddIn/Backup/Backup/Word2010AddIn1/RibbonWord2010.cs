using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Office.Tools.Ribbon;
using Tools = Microsoft.Office.Tools;

namespace Word2010AddIn1
{
    public partial class RibbonWord2010
    {
        private void RibbonWord2010_Load(object sender, RibbonUIEventArgs e)
        {
           
        }

        private void addButtonCheckBox_Click(object sender, RibbonControlEventArgs e)
        {
            Globals.ThisAddIn.ToggleCheckbox();
        }

        private void btnFillTable_Click(object sender, RibbonControlEventArgs e)
        {
            bool error = !Globals.ThisAddIn.fillFirstWordTable();
            if (error)  //如果要填写用户选定的表，则需要其他接口。
            {
                System.Windows.Forms.MessageBox.Show("没有找到表格或表格不规范无法填写!");        
            }
        }

        private void toggleButton1_Click(object sender, RibbonControlEventArgs e)
        {
            //Globals.ThisAddIn.myTableAssiant.Visible = tbgTableAssiant.Checked;//本语句是可以正常工作的。
            Globals.ThisAddIn.tablePane.Visible = ((RibbonToggleButton)sender).Checked;

            //Tools.CustomTaskPane aTableAssiant = Globals.ThisAddIn.CustomTaskPanes.Single(ctp => ctp.Title == "智能填表辅助");//智能填表辅助是创建对象时，制定的title，不是对象的label属性。
            //aTableAssiant.Visible =tbgTableAssiant.Checked;
        }
    }
}

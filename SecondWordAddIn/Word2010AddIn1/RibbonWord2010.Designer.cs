namespace Word2010AddIn1
{
    partial class RibbonWord2010 : Microsoft.Office.Tools.Ribbon.RibbonBase
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        public RibbonWord2010()
            : base(Globals.Factory.GetRibbonFactory())
        {
            InitializeComponent();
        }

        /// <summary> 
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region 组件设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.MyRibbonTab = this.Factory.CreateRibbonTab();
            this.group1 = this.Factory.CreateRibbonGroup();
            this.addButtonCheckBox = this.Factory.CreateRibbonCheckBox();
            this.group2 = this.Factory.CreateRibbonGroup();
            this.btnFillTable = this.Factory.CreateRibbonButton();
            this.tbgTableAssiant = this.Factory.CreateRibbonToggleButton();
            this.MyRibbonTab.SuspendLayout();
            this.group1.SuspendLayout();
            this.group2.SuspendLayout();
            // 
            // MyRibbonTab
            // 
            this.MyRibbonTab.ControlId.ControlIdType = Microsoft.Office.Tools.Ribbon.RibbonControlIdType.Office;
            this.MyRibbonTab.Groups.Add(this.group1);
            this.MyRibbonTab.Groups.Add(this.group2);
            this.MyRibbonTab.Label = "智能填表";
            this.MyRibbonTab.Name = "MyRibbonTab";
            // 
            // group1
            // 
            this.group1.Items.Add(this.addButtonCheckBox);
            this.group1.Items.Add(this.btnFillTable);
            this.group1.Name = "group1";
            // 
            // addButtonCheckBox
            // 
            this.addButtonCheckBox.Label = "添加按钮";
            this.addButtonCheckBox.Name = "addButtonCheckBox";
            this.addButtonCheckBox.Visible = false;
            this.addButtonCheckBox.Click += new Microsoft.Office.Tools.Ribbon.RibbonControlEventHandler(this.addButtonCheckBox_Click);
            // 
            // group2
            // 
            this.group2.Items.Add(this.tbgTableAssiant);
            this.group2.Name = "group2";
            // 
            // btnFillTable
            // 
            this.btnFillTable.ControlSize = Microsoft.Office.Core.RibbonControlSize.RibbonControlSizeLarge;
            this.btnFillTable.Image = global::Word2010AddIn1.Properties.Resources._35;
            this.btnFillTable.Label = "自动填写";
            this.btnFillTable.Name = "btnFillTable";
            this.btnFillTable.ShowImage = true;
            this.btnFillTable.Click += new Microsoft.Office.Tools.Ribbon.RibbonControlEventHandler(this.btnFillTable_Click);
            // 
            // tbgTableAssiant
            // 
            this.tbgTableAssiant.ControlSize = Microsoft.Office.Core.RibbonControlSize.RibbonControlSizeLarge;
            this.tbgTableAssiant.Image = global::Word2010AddIn1.Properties.Resources._16_s;
            this.tbgTableAssiant.Label = "显示辅助窗口";
            this.tbgTableAssiant.Name = "tbgTableAssiant";
            this.tbgTableAssiant.ShowImage = true;
            this.tbgTableAssiant.Click += new Microsoft.Office.Tools.Ribbon.RibbonControlEventHandler(this.toggleButton1_Click);
            // 
            // RibbonWord2010
            // 
            this.Name = "RibbonWord2010";
            this.RibbonType = "Microsoft.Word.Document";
            this.Tabs.Add(this.MyRibbonTab);
            this.Load += new Microsoft.Office.Tools.Ribbon.RibbonUIEventHandler(this.RibbonWord2010_Load);
            this.MyRibbonTab.ResumeLayout(false);
            this.MyRibbonTab.PerformLayout();
            this.group1.ResumeLayout(false);
            this.group1.PerformLayout();
            this.group2.ResumeLayout(false);
            this.group2.PerformLayout();

        }

        #endregion

        internal Microsoft.Office.Tools.Ribbon.RibbonTab MyRibbonTab;
        internal Microsoft.Office.Tools.Ribbon.RibbonGroup group1;
        internal Microsoft.Office.Tools.Ribbon.RibbonCheckBox addButtonCheckBox;
        internal Microsoft.Office.Tools.Ribbon.RibbonButton btnFillTable;
        internal Microsoft.Office.Tools.Ribbon.RibbonGroup group2;
        internal Microsoft.Office.Tools.Ribbon.RibbonToggleButton tbgTableAssiant;
    }

    partial class ThisRibbonCollection
    {
        internal RibbonWord2010 RibbonWord2010
        {
            get { return this.GetRibbon<RibbonWord2010>(); }
        }
    }
}

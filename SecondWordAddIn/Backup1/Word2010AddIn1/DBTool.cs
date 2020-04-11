using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Windows.Forms;
using System.Data.OleDb;
/*
 * DBTool说明
 * 负责从数据中获取相关元数据和具体的信息。其中元数据一旦获取可以填写相关的对象，以便连续使用？还是一直从数据库中获取数据，更加简单些。
 * 但是这样的话，对数据的访问要尽可能地独立于数据库访问代码，抽象好。一种具体的办法就是获取数据后马上填写 TableMetaInfo.cs中的相关类。
 */
namespace Word2010AddIn1
{
     
     public struct tableFieldInfo//
    {
        public string tableName;
        public string fieldName;
        public string fieldType;
        public string fieldDesc;
        public string fieldValue;
    }
    public class DBTool
    {
        public static string userID = "3420324";
        private OleDbConnection accessConn = null;
        private List<tableFieldInfo> publicTableMetaInfo;
        private DataSet allBasicInfoDataSet;
        private bool allBasicInfoInited = false;
        public DBTool()
        {
            publicTableMetaInfo = new List<tableFieldInfo>();
            allBasicInfoDataSet = new DataSet();
        }
        public bool initDatabase()
        {
            
            //string appPath = Environment.CurrentDirectory + "\\";//该接口测试的结果为“C:\\Users\\Leo.TANG\\Documents\\”，不是希望的路径。
            string appPath = System.IO.Directory.GetCurrentDirectory() + "\\";//该接口测试的结果为希望的路径。  //发布后, 单独word运行时,实际路径为"windows/system32!!!
            //TO_DO：读取注册表，获得插件库所在的位置，配置appPath
            string accessDBConnstr = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=" + appPath + "\\TeacherAndTableMetadata.accdb;Persist Security Info=True";//!!调试可以这样,Release时只能是固定路径!? 不是的! release模式调试也要在该目录下存放数据库.
            if (ThisAddIn.selfDebugMessage)  System.Windows.Forms.MessageBox.Show("数据库位置"+accessDBConnstr);
            accessConn = new OleDbConnection(accessDBConnstr);
            try
            {
                accessConn.Open();
                if (ThisAddIn.selfDebugMessage)  System.Windows.Forms.MessageBox.Show("数据库已打开");

            }
            catch
            {
                return false;
            }
            return true;
        }
        public ConnectionState getDBConnectionState()
        {
            return accessConn.State;
        }
        public bool getPubTableMetaInfo()//从数据库中获取基本的数据字典信息，如果换数据库的话，以后可以考虑在数据库中创建专门的字典表。
        {

          /* string strSQL = "select count(*) from BasicInfo";
           OleDbCommand dbcommand = new OleDbCommand(strSQL, accessConn);
           object recordcount = dbcommand.ExecuteScalar();
           textBox1.Text = ((Int32)recordcount).ToString();*/
            try
            {
                DataTable tableColumns = accessConn.GetOleDbSchemaTable(OleDbSchemaGuid.Columns, new string[] { null, null, "BasicInfo", null });
                foreach (DataRow row in tableColumns.Rows)
                {
                    tableFieldInfo aFieldInfo = new tableFieldInfo();
                    aFieldInfo.fieldName = row["COLUMN_NAME"].ToString();
                    aFieldInfo.fieldType = row["DATE_TYPE"].ToString();
                    aFieldInfo.fieldDesc = row["DESCRIPTION"].ToString();
                    aFieldInfo.tableName = "BasicInfo";

                    publicTableMetaInfo.Add(aFieldInfo);

                }

            }
            catch
            {
                return false;
            }
            return true;
        }
        public OleDbDataReader getDataReaderBySQL(string vStrSQL)
        {
            OleDbDataReader result = null;//每次打开一个新的Reader必须先关闭前一个，和Delphi的TADOQuery一样
            OleDbCommand cmd = new OleDbCommand(vStrSQL, accessConn);
            result = cmd.ExecuteReader();
            return result;
            //result.HasRows();
        }
        public DataSet getDatasetBySQL(string vstrSQL)
        {
            OleDbDataAdapter oleDa = new OleDbDataAdapter(vstrSQL, accessConn);
            DataSet result = new DataSet();
            try
            {
                oleDa.Fill(result);
                return result;//后期可通过rows属性访问各个列，可以通过TableName访问表的名称。
            }
            catch
            {
                return null;
            }
        }
        //根据用户身份证，获取所有基本信息
        public void initAllBasicInfoByID(string vID)
        {
            string strSQL = string.Format("select * from BasicInfo a,EducationBackground b where a.ArmyID=b.ArmyID and a.ArmyID={0:}", "'"+vID+"'");
            allBasicInfoDataSet = getDatasetBySQL(strSQL);
            if ((allBasicInfoDataSet.Tables.Count == 0) || (allBasicInfoDataSet.Tables[0].Rows.Count == 0)) allBasicInfoDataSet = null;
            allBasicInfoInited = true;
            if (ThisAddIn.selfDebugMessage)
            {
                if (allBasicInfoInited) System.Windows.Forms.MessageBox.Show("数据已加载!");
            }
        }

        public string getTempValueByFieldName(string vFieldName)
        {

            string aContentValue = "";
            string aContentHint = vFieldName;
            if (aContentHint.Equals("姓名"))
            {
                aContentValue = "王五";
            }
            else if (aContentHint.Equals("性别"))
            {
                aContentValue = "男";
            }
            else if (aContentHint.Equals("年龄"))
            {
                aContentValue = "35";
            }
            else if (aContentHint.Equals("民族"))
            {
                aContentValue = "汉";
            }
            else if (aContentHint.Equals("出生年月"))
            {
                aContentValue = "1980.11";
            }
            else if (aContentHint.Equals("出生日期"))
            {
                aContentValue = "1980.11.11";
            }
            else if (aContentHint.Equals("籍贯"))
            {
                aContentValue = "江苏南京";
            }
            else if (aContentHint.Equals("政治面貌"))
            {
                aContentValue = "党员";
            }
            else if (aContentHint.Equals("部职别") || aContentHint.Equals("现部职别"))
            {
                aContentValue = "理工大学指挥信息系统学院副教授";
            }
            else if (aContentHint.Equals("入伍(工作)时间"))
            {
                aContentValue = "1998.09";
            }
            else if (aContentHint.Equals("任职时间"))
            {
                aContentValue = "2010.12";
            }
            else if (aContentHint.Equals("证件号"))
            {
                aContentValue = "参字第******";
            }
            else if (aContentHint.Equals("家庭住址"))
            {
                aContentValue = "南京******";
            }
            else if (aContentHint.Equals("获得时间"))//需要上下文
            {
                aContentValue = "2005.06";
            }
            else if (aContentHint.Equals("最高学位"))
            {
                aContentValue = "硕士";
            }
            else if (aContentHint.Equals("获得学校"))//需要上下文
            {
                aContentValue = "理工大学";
            }
            else if (aContentHint.Equals("技术等级"))
            {
                aContentValue = "技术9级";
            }
            else if (aContentHint.Equals("等级时间"))
            {
                aContentValue = "2013.12";
            }
            else if (aContentHint.Equals("军衔(文职级)"))//需要关联包含
            {
                aContentValue = "中校";
            }
            else if (aContentHint.Equals("军衔(文职级)时间"))//需要关联包含
            {
                aContentValue = "2014.02";
            }
            else if (aContentHint.Equals("参加何学术团体及担任何职务"))
            {
                aContentValue = "无";
            }
            else if (aContentHint.Equals("社会兼职"))
            {
                aContentValue = "无";
            }
            return aContentValue;
        }

        public string getBasicCalculateFieldValueByMeta(FillMedadata vFMetaData)
        {
            //可以临时用getTempValueByFieldName(vFieldName)代替
            /*      PropertyName
                    现军衔及时间
                    军衔(文职级)时间
                    军衔(文职级)
                    教龄
                    获得时间
                    获得学校及专业
                    最高学位
                    学历学位*/
            if (!allBasicInfoInited) return string.Empty;
            else if (allBasicInfoDataSet == null) return string.Empty;
            else
            {
                try
                {
                    if (vFMetaData.proMetaName.Equals("现军衔及时间"))
                    {
                        string rank = "";
                        // rankTime = System.DateTime.Now;
                        string rankTime = "";
                        string rankProMetaName =  "军衔";
                        string rankTimeProMetaName = "军衔时间";
                        rank = getBasicFieldValueByProMetaName(rankProMetaName);
                        rankTime = getBasicFieldValueByProMetaName(rankTimeProMetaName);
                        DateTime aDT = DateTime.Parse(rankTime);
                        rankTime = aDT.Year.ToString() + "." + aDT.Month.ToString();
                        return rank + rankTime;                       
                    }
                    else if (vFMetaData.proMetaName.Equals("军衔(文职级)时间"))
                    {
                        string rank = "";
                        // rankTime = System.DateTime.Now;
                        string rankTime = "";
                        string rankProMetaName = "军衔";
                        string TimeProMetaName = "军衔时间";
                        rank = getBasicFieldValueByProMetaName(rankProMetaName);
                        if (rank.Equals(string.Empty))//则计算文职时间
                            TimeProMetaName = "等级时间";
                        rankTime = getBasicFieldValueByProMetaName(TimeProMetaName);
                        DateTime aDT = DateTime.Parse(rankTime);
                        rankTime = aDT.Year.ToString() + "." + aDT.Month.ToString();

                        return  rankTime;
                    }
                    else if (vFMetaData.proMetaName.Equals("军衔(文职级)"))
                    {
                        string rank = "";
                        // rankTime = System.DateTime.Now;
                        string rankProMetaName = "军衔";
                        rank = getBasicFieldValueByProMetaName(rankProMetaName);
                        if (rank.Equals(string.Empty))//则计算文职时间
                        {
                            rankProMetaName = "文职级";
                            rank = getBasicFieldValueByProMetaName(rankProMetaName);
                        } 
                        return rank;
                    }
                    else if (vFMetaData.proMetaName.Equals("教龄"))
                    {                                            
                        string workDate = "";
                        string workDateProMetaName = "工作时间";
                        int workYear = DateTime.Parse(getBasicFieldValueByProMetaName(workDateProMetaName)).Year;
                        workDate = (DateTime.Now.Year - workYear).ToString();
                        return workDate.ToString();
                    }
                    else if (vFMetaData.proMetaName.Equals("获得时间"))//需要上下文！可能是学历也可能是学位，也可能是军衔或文职级等等，太多，暂不处理
                    {
                        return "需要上下文，暂未处理";
                    }
                    else if (vFMetaData.proMetaName.Equals("获得学校及专业"))//需要上下文！可能是学历也可能是学位
                    {
                        return "需要上下文，暂未处理";
                    }
                    else if (vFMetaData.proMetaName.Equals("最高学位"))
                    {//看看获得过什么学位
                        string degree = "";
                        string degreeProMetaName = "博士";
                        degree = getBasicFieldValueByProMetaName(degreeProMetaName);
                        if (!Boolean.Parse(degree))
                        {
                            degreeProMetaName = "硕士";
                            degree = getBasicFieldValueByProMetaName(degreeProMetaName);
                            if (!Boolean.Parse(degree))
                            {
                                degreeProMetaName = "学士";
                                degree = getBasicFieldValueByProMetaName(degreeProMetaName);
                                if (!Boolean.Parse(degree))
                                {
                                    degreeProMetaName = "大专";
                                }
                            }
                        }
                        degree = degreeProMetaName;
                        return degree;

                    }
                    else if (vFMetaData.proMetaName.Equals("学历学位"))//
                    {
                        string degree = "";
                        string degreeProMetaName = "博士";
                        degree = getBasicFieldValueByProMetaName(degreeProMetaName);
                        if (!Boolean.Parse(degree))
                        {
                            degreeProMetaName = "硕士";
                            degree = getBasicFieldValueByProMetaName(degreeProMetaName);
                            if (!Boolean.Parse(degree))
                            {
                                degreeProMetaName = "学士";
                                degree = getBasicFieldValueByProMetaName(degreeProMetaName);
                                if (!Boolean.Parse(degree))
                                {
                                    degreeProMetaName = "大专";
                                }
                            }
                        }
                        degree = degreeProMetaName;
                        string Education = "";
                        string EducationProMetaName = "最高学历";
                        Education = getBasicFieldValueByProMetaName(EducationProMetaName);
                        return Education + degree;
                    }
                    else
                    {// 
                        return string.Empty;
                    }
                }
                catch//DataTable中没有该列
                {
                    return string.Empty;
                } 
            }
        }
        public string getBasicFieldValueByName(string vFieldName)
        {
            //可以临时用getTempValueByFieldName(vFieldName)代替
            if (!allBasicInfoInited) return string.Empty;
            else if (allBasicInfoDataSet == null) return string.Empty;
            else
            {
                try
                {
                    DataRow aRow = allBasicInfoDataSet.Tables[0].Rows[0];
                    Object result = null;
                    if (vFieldName.Equals("ArmyID")) vFieldName = "a."+vFieldName;//因为连接查询中ArmyID字段有两个, 且无法通过 select a.ArmyID as ArmyID 进行修改,因为还是有歧义,改成其他的可以.
                    //System.Type columnDataType = (
                    result = aRow[vFieldName];
                    return result.ToString();

                    if (aRow.Table.Columns[vFieldName].DataType == System.Type.GetType("System.DateTime"))
                    {//时间、日期都改为 年月的显式形式
                        DateTime aDT = (System.DateTime)result;
                        return aDT.Year.ToString() + "." + aDT.Month.ToString();  //返回这样的日期值，其实对其他应用场合也不好，还是直接返回日期最好。
                    }
                    else
                    {
                        return result.ToString();
                    }
                }
                catch//DataTable中没有该列
                {
                    return string.Empty;
                }
 
            }
        }
        public string getBasicFieldValueByProMetaName(string vProMetaName)
        {
            FillMedadata aPMetaData = FillMedadataToolHelper.getFillMedadataTool().getSingleFillMedadata(vProMetaName);
            if (aPMetaData != null)
            {
                return getBasicFieldValueByName(aPMetaData.mappedFieldName);
            }
            return string.Empty;
                        
 
        }
        /*
         * 根据提供的meta信息，比如其中的字段名称获取相应数据库中的数据
         * 为什么不直接根据字段名称呢？因为后期的话可能需根据meta中的表名称等信息逐个从数据库中查询，现在的方法是直接一次性获取所有基本信息，基本信息的存储是按字段名称的。
         * 这样设计具备一定的扩展性。
         */
        public string getSimpleValueByMetadata(FillMedadata vProMeta)
        {
            string result;
            if (vProMeta.mappedFieldName.Equals(string.Empty)) return string.Empty;
            if (vProMeta.mappedFieldName.Equals("calculate"))
            {
                result = getBasicCalculateFieldValueByMeta(vProMeta);
            }
            else
            {
                result = getBasicFieldValueByName(vProMeta.mappedFieldName);
                //统一改变日期类型的值为年月
                if ((vProMeta.defaultDataType.Equals("date")) && (!result.Equals(string.Empty)))
                {
                    DateTime aDT = DateTime.Parse(result);
                    result = aDT.Year.ToString() + "." + aDT.Month.ToString();
                }
               //转义布尔值，如党员
                else if (vProMeta.defaultDataType.Equals("boolean"))
                {
                    Boolean aB = Boolean.Parse(result);
                    if (aB)
                    {
                        if (vProMeta.proMetaName.Equals("党员"))
                        {
                            result = "党员";
                        }
                    }
                    else
                    {
                        if (vProMeta.proMetaName.Equals("党员"))
                        {
                            result = "团员";
                        }
                    }
                }
            }
            if (result.Equals(string.Empty)) return result;//以后可以考虑为再次从数据库中查找
            else return result;

        }
    }
    public class DBToolHelper //确保只能生成一个DBTool对象
    {
        private static DBTool mDBTool;
        public static DBTool getDBTool()
        {
            if (mDBTool == null)
            {
                mDBTool = new DBTool();
                if (!mDBTool.initDatabase()) mDBTool = null;
                else mDBTool.initAllBasicInfoByID(DBTool.userID);
            }

            return mDBTool;
        }
        public DBToolHelper()
        {
            mDBTool = null;
        }
    }
}

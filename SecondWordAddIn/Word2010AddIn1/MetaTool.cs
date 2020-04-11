using System;
using System.Data;
using System.Data.OleDb;
using System.Data.Common;
using System.Collections.Generic;
namespace Word2010AddIn1
{

    public class FillMedadata
    {
        public string subjectName;
        public string proMetaName;
        public string srcTableName;
        public string fieldDesc;
        public string defaultDataType;
        public string mappedFieldName;//对应数据库中的表字段名称
        public bool isMappedCalField;//是否对应着计算字段
        public string mappedCalFormula;//如果是计算字段形式的, 此变量为相应的表达式
        public List<string> thesaurus;//同义词字典
        public FillMedadata()
        {
            thesaurus = new List<string>();
        }
        public bool setProMetaInfoByString(string vHintValue)//这个接口用处不大，现在是直接一次性获取基本填表元数据。而对于list等复杂元数据的获取？？
        {
            bool result = false;
            proMetaName = vHintValue;//TO_DO: 通过数据库进行查找等操作完成具体的设置,包括类的其他成员值也要设置.
            result = true;
            return result;
        }
        public void setProMetaInfoByDataReader(DbDataReader vDR)
        {
            subjectName = vDR["SubjectName"].ToString();
            proMetaName = vDR["PropertyName"].ToString();
            srcTableName = vDR["SrcTableName"].ToString();
            fieldDesc = vDR["FieldDesc"].ToString();
            defaultDataType = vDR["DefaultDataType"].ToString();
            mappedFieldName = vDR["FieldName"].ToString();
        }
        public bool isThisFillMedadata(string vHintvalue)
        {
//            if (proMetaName) return true;
            foreach ( string aThesaurus in thesaurus)
            {
               if (aThesaurus.Equals(vHintvalue)) return true;
            }
            return false;
        }

    }
    public class FillMedadataTool
    {
        private List<FillMedadata> baseMetadataList;
        public FillMedadata getSingleFillMedadata(string vHintvalue,string vSubjectName="BASIC")//直接获取基本信息类型的相关元数据
        {
            if (vSubjectName.Equals("BASIC"))
            {
                foreach (FillMedadata aFM in baseMetadataList)
                {
                    if (aFM.isThisFillMedadata(vHintvalue)) return aFM;
                }
            }
            else return null;//暂未实现其他元数据的处理
            return null;
        }

        private void initBaseMetadataListFromDB()
        {
            //1. 查找库表“Meta_Basic” 构建baseMetadataList
            DBTool aDBTool = DBToolHelper.getDBTool();
            if (aDBTool != null)
            {
                string strSQL = "select * from Meta_Basic";
                OleDbDataReader aOleDR = aDBTool.getDataReaderBySQL(strSQL);
                while (aOleDR.Read())
                {
                    FillMedadata aFM = new FillMedadata();
                    aFM.setProMetaInfoByDataReader(aOleDR);
                    baseMetadataList.Add(aFM);

                }
                aOleDR.Close();
            }
            
        }
        private void initThesaurusFromDB()
        {//为每个元数据填写相应的同义词。从数据中查找，需要分类。

            //1. 查找库表“Meta_Basic” 构建baseMetadataList
            DBTool aDBTool = DBToolHelper.getDBTool();
            if (aDBTool != null)
            {
                string strSQL = "select * from Thesaurus";

                DataSet aDS = aDBTool.getDatasetBySQL(strSQL);
                DataTable aDT = aDS.Tables[0];
                DataRow[] drs = null;
                foreach (FillMedadata aFM in baseMetadataList)
                {
                    drs = aDT.Select("PropertyName='"+aFM.proMetaName+"'");//给出筛选条件： 同义词中是否有PropertyName＝元数据中的PropertyName
                    if (drs.Length == 1)
                    {
                        foreach (DataRow dr in drs)
                        {
                            foreach (DataColumn dc in aDT.Columns)
                            {
                                if (!dc.ColumnName.Equals("SubjectName"))
                                {
                                    if (!dr[dc].ToString().Equals(string.Empty))
                                        aFM.thesaurus.Add(dr[dc].ToString());
                                }
                            }
                        }
                    }

                }

            }

        }
        public FillMedadataTool()
        {
            baseMetadataList = new List<FillMedadata>();
            initBaseMetadataListFromDB();
            initThesaurusFromDB();
        }

    }
    public class FillMedadataToolHelper
    {
        private static FillMedadataTool mFillMedadataTool;
        public static FillMedadataTool getFillMedadataTool()
        {
            if (mFillMedadataTool == null)
            {
                mFillMedadataTool = new FillMedadataTool();

            }
            return mFillMedadataTool;
        }
        public FillMedadataToolHelper()
        {
            mFillMedadataTool = null;
        }
    }
}

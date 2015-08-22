#!/bin/sh

bin=/home/tiancaizjzk/Downloads/elasticsearch-jdbc-1.7.1.0/bin
lib=/home/tiancaizjzk/Downloads/elasticsearch-jdbc-1.7.1.0/lib

echo '{
    "type" : "jdbc",
    "jdbc" : {
        "url" : "jdbc:mysql://55c363ec18c71.sh.cdb.myqcloud.com:7275/collegebox?characterEncoding=utf-8",
        "user" : "cdb_outerroot",
        "password" : "zjzk1234",
        "sql" :  "select \"collegebox\" as \"_index\",\"college\" as \"_type\", college.college_id as \"_id\", college.college_id,college_name,concat(college_country,\" \",college_area) as college_area,college_ranking,college_intro,college_surrounding, concat(school_name,\":\",school_intro) as school_intro, concat(school_name,\"-\",major_name,\":\",major_intro) as major_intro, concat(school_name,\"-\",major_name,\"-\",degree_name,\":\",degree_requirements) as degree_requirements from college left join school on college.college_id = school.college_id left join major on school.school_id = major.school_id left join degree on major.major_id = degree.major_id"
    }
}
' | java \
    -cp "${lib}/*" \
    -Dlog4j.configurationFile=${bin}/log4j2.xml \
    org.xbib.tools.Runner \
    org.xbib.tools.JDBCImporter


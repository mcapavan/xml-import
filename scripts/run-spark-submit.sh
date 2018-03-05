#!/usr/bin/env bash

export SPARK_MAJOR_VERSION=2

echo spark-submit \
--packages com.databricks:spark-xml_2.11:0.4.1 \
--class book \
 /root/java-code/xml-import-1.0-SNAPSHOT.jar

spark-submit
    --packages com.databricks:spark-xml_2.11:0.4.1 \
    --class book \
     /root/java-code/xml-import-1.0-SNAPSHOT.jar
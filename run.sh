#!/bin/sh
############################################################																												
# Project         : Health IT simulation
# Author          : James Wafula
# Date            : 23-03-2016
# Organization    : KEMRI Wellcome Trust
# Department      : HSRG (Data & Analytics Team)
############################################################
cd /home/$USER/Documents/ec2/interoperability
echo "....................................................."
echo "Preparing system for data extraction and transfer ..."
echo "....................................................."
ant clean
ant build
echo "....................................................."
echo "Transfering data from server1 to server2 ..."
echo "....................................................."
# allow multiple terminals

echo -n "Enter the sending server's address: > "
read sender_addr
echo -n "Enter the sending server's private keypath: > "
read key
ssh -vL 3307:ec2-54-93-191-177.eu-central-1.compute.amazonaws.com:3306 -i "$key" ubuntu@$sender_addr

# /home/james/Documents/ec2/ec2-suse.pem
# ssh -vL 3307:ec2-54-93-191-177.eu-central-1.compute.amazonaws.com:3306 -i "ec2-suse.pem" ubuntu@ec2-54-93-191-177.eu-central-1.compute.amazonaws.com
#----Open new term here and run:
#----mysql -uredcap -p -P 3307 -h 127.0.0.1 -e "use openmrs; SELECT * FROM user_role;" > data/temp2.csv
#----mysqldump -uredcap -p -P 3307 -h 127.0.0.1 openmrs > data/openmrs.sql
#----allow reading of password

#java -ea -Xmx2g -cp classes:lib/poi-3.9.jar:lib/mysql-connector-java-5.1.13-bin.jar:lib/jsch-0.1.53.jar Transfer
# Can ssh another server as above and dump a database or send file accross -- then insert vals into a table in another server

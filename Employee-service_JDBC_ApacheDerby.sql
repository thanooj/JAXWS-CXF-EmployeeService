ij> CONNECT 'jdbc:derby://localhost:1527/D:/study/db-derby-10.12.1.1-bin/bin/db';

ij> create table thanooj.EMPLOYEE(id bigint primary key, firstname varchar(30), lastname varchar(30), dept varchar(30), doj varchar(30), dno varchar(30), line varchar(30), street varchar(30), city varchar(30), state varchar(30), country varchar(30), zipcode bigint);
0 rows inserted/updated/deleted


ij> describe thanooj.employee;
COLUMN_NAME         |TYPE_NAME|DEC&|NUM&|COLUM&|COLUMN_DEF|CHAR_OCTE&|IS_NULL&
------------------------------------------------------------------------------
ID                  |BIGINT   |0   |10  |19    |NULL      |NULL      |NO
FIRSTNAME           |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
LASTNAME            |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
DEPT                |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
DOJ                 |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
DNO                 |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
LINE                |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
STREET              |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
CITY                |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
STATE               |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
COUNTRY             |VARCHAR  |NULL|NULL|30    |NULL      |60        |YES
ZIPCODE             |BIGINT   |0   |10  |19    |NULL      |NULL      |YES



ij> INSERT INTO THANOOJ.EMPLOYEE VALUES(1, 'Sriram', 'Ayodhya', 'DEV', '25-09-1983', '35','7th Line', 'Tavarekere, BTM','Bangalore','KA','IN',560029);



ij> select * from thanooj.employee;

ID                  |FIRSTNAME                     |LASTNAME                      |DEPT                          |DOJ                           |DNO                           |LINE                          |STREET                        |CITY                          |STATE                         |COUNTRY                       |ZIPCODE
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1                   |Sriram                        |Ayodhya                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
2                   |seetha                        |midhila                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
3                   |Sriram                        |Ayodhya                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
4                   |seetha                        |midhila                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
6                   |raghavaram                    |Ayodhya                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |25-09-1983                    |Bangalore                     |KA                            |IN                            |560029

ID                  |FIRSTNAME                     |LASTNAME                      |DEPT                          |DOJ                           |DNO                           |LINE                          |STREET                        |CITY                          |STATE                         |COUNTRY                       |ZIPCODE
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1                   |Sriram                        |Ayodhya                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
2                   |seetha                        |midhila                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
3                   |Sriram                        |Ayodhya                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
4                   |seetha                        |midhila                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |35                            |Bangalore                     |KA                            |IN                            |560029
6                   |raghavaram                    |Ayodhya                       |DEV                           |25-09-1983                    |25-09-1983                    |25-09-1983                    |25-09-1983                    |Bangalore                     |KA                            |IN                            |560029
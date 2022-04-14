USE Master					
	GO					
	IF  EXISTS (SELECT * FROM SYSdatabases  WHERE Name = N'QLSV_DB')					
	Drop Database QLSV_DB				
	Go					
	Create database QLSV_DB					
	on					
	( Name = 'QLSV_DB_dat', FILENamE='D:\Project\Java\PhanMemQLSV_Java\QLSV_DB\QLSV_DB.mdf',					
	size= 5MB,					
	Maxsize=10MB,					
	filegrowth=1MB)					
	LOG ON					
	( Name = 'QLSV_DB_log', FILENamE='D:\Project\Java\PhanMemQLSV_Java\QLSV_DB\QLSV_DB.ldf',					
	size= 1MB,					
	Maxsize=5MB,					
	filegrowth=1MB) 					
	GO					
	--------------------------------------------					
	USE QLSV_DB				
	GO
	-------STUDENTS-----------------------------
	IF  EXISTS (SELECT * FROM SYSOBJECTS  WHERE Name = N'STUDENTS')					
	Drop table STUDENTS					
	Go					
	Create table STUDENTS(
		ID_STD NVARCHAR(50) NOT NULL,
		NAME NVARCHAR(50) NULL,
		EMAIL NVARCHAR(50) NULL,
		PHONE NVARCHAR(15) NULL,
		ADDRESS NVARCHAR(150) NULL,
		AGE INT NULL,
		GENDER BIT NULL,
		ID_GRA NVARCHAR(50) NULL,
		CONSTRAINT PK_STUDENTS PRIMARY KEY (ID_STD)	
	)
	-------GRADE--------------------------------
	IF  EXISTS (SELECT * FROM SYSOBJECTS  WHERE Name = N'GRADE')					
	Drop table GRADE					
	Go					
	Create table GRADE(
		ID_GRA NVARCHAR(50) NOT NULL,
		NAME NVARCHAR(50) NULL,
		FACULTY NVARCHAR(50) NULL,
		CONSTRAINT PK_GRADE PRIMARY KEY (ID_GRA)
	)
	------SUBJECT-------------------------------
	IF  EXISTS (SELECT * FROM SYSOBJECTS  WHERE Name = N'SUBJECT')					
	Drop table SUBJECT					
	Go					
	Create table SUBJECT(
		ID_SUB NVARCHAR(50) NOT NULL,
		NAME NVARCHAR(50) NULL,
		CREDIT INT NULL,
		FEE FLOAT NULL,
		CONSTRAINT PK_SUBJECT PRIMARY KEY (ID_SUB)
	)
	
	------SCORE-------------------------------
	IF  EXISTS (SELECT * FROM SYSOBJECTS  WHERE Name = N'SCORE')					
	Drop table SCORE					
	Go					
	Create table SCORE(
		ID_SUB NVARCHAR(50) NOT NULL,
		ID_STD NVARCHAR(50) NOT NULL,
		D_CHUYENCAN FLOAT NULL,
		D_THI FLOAT NULL,
		CONSTRAINT PK_SCORE PRIMARY KEY (ID_SUB,ID_STD)
	)
	
	--------USERS-------------------------------
	IF  EXISTS (SELECT * FROM SYSOBJECTS  WHERE Name = N'USERS')					
	Drop table USERS					
	Go					
	Create table USERS(
		USERNAME NVARCHAR(50) NOT NULL,
		PASSWORDD NVARCHAR(50) NULL,
		ROLE NVARCHAR(50) NULL,
		CONSTRAINT PK_USERS PRIMARY KEY(USERNAME)
	)
	----------------------------------------
	insert into STUDENTS values
	('STD001','Nguyen Van A','a@gmail.com','0921063488','12 street ha noi',20,1,'GRA001'),
	('STD002','Pham Van B','a@gmail.com','0921063488','12 street ha noi',20,1,'GRA002'),
	('STD003','Nguyen Van C','a@gmail.com','0921063488','12 street ha noi',20,0,'GRA003'),
	('STD004','Nguyen Van D','a@gmail.com','0921063488','12 street ha noi',20,1,'GRA004'),
	('STD005','Nguyen Van E','a@gmail.com','0921063488','12 street ha noi',20,0,'GRA005')

	insert into GRADE values
	('GRA001','18CN1','CNTT'),
	('GRA002','18CN2','TT'),
	('GRA003','18CN3','CNTT'),
	('GRA004','18CN4','CNTT'),
	('GRA005','18CN5','CNTT')

	insert into SUBJECT values
	('SUB001', 'C#',3,600000),
	('SUB002', 'C++',3,600000),
	('SUB003', 'Python',3,600000),
	('SUB004', 'Java',3,600000),
	('SUB005', 'Lua',3,600000)

	insert into SCORE values
	('SUB001', 'STD001', null, null),
	('SUB002', 'STD002', null, null),
	('SUB003', 'STD003', null, null),
	('SUB004', 'STD004', null, null),
	('SUB005', 'STD005', null, null),
	('SUB001', 'STD004', null, null)

	select STUDENTS.NAME
	from STUDENTS
	join GRADE 
		on STUDENTS.ID_GRA = GRADE.ID_GRA
	join SCORE 
		on STUDENTS.ID_STD =SCORE.ID_STD
	join SUBJECT 
		on SUBJECT.ID_SUB=SCORE.ID_SUB
	where GRADE.NAME= '18CN4'
	order by STUDENTS.ID_STD

	update SCORE
	set  SCORE.D_CHUYENCAN=4, SCORE.D_THI=4
	where SCORE.ID_STD=(select ID_STD from STUDENTS where NAME='Nguyen Van D' ) and SCORE.ID_SUB=(select ID_SUB from SUBJECT where NAME='Java')

	

	insert into STUDENTS(ID_STD, NAME,EMAIL,PHONE, ADDRESS,AGE, GENDER, ID_GRA)
	select 'STD006','Nguyen Van E','a@gmail.com','0921063488','12 street ha noi',20,0,GRADE.ID_GRA
	from GRADE
	where GRADE.NAME='GRA001'

	select ID_GRA 
	from GRADE
	where NAME = '18CN5'

	select ID_GRA 
	from GRADE
	where NAME = '18CN2'
	select * from STUDENTS
	select * from GRADE
	select * from SCORE
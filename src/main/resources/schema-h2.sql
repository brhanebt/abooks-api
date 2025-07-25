CREATE TABLE if not exists "ABT_AMAZONBOOKS" 
   (	"ISBN" VARCHAR(20) primary key, 
	"BOOKTITLE" VARCHAR(200), 
	"BOOKAUTHOR" VARCHAR(100), 
	"YEAROFPUBLICATION" NUMBER, 
	"PUBLISHER" VARCHAR(100), 
	"IMAGEURLS" VARCHAR(250), 
	"IMAGEURLM" VARCHAR(250), 
	"IMAGEURLL" VARCHAR(250)
   );

    CREATE TABLE if not exists "ABT_USERS" 
   (	"USERID" INTEGER NOT NULL, 
	"LOCATION" VARCHAR(100), 
	"AGE" NUMBER, 
	 CONSTRAINT "PK_USERID" PRIMARY KEY ("USERID"));

     CREATE TABLE if not exists "ABT_RATINGS" ("USERID" INTEGER NOT NULL, 
	"ISBN" VARCHAR(20), 
	"BOOKRATING" NUMBER, 
	 CONSTRAINT "PK_USERID_ISBN" PRIMARY KEY ("USERID", "ISBN"),
	 CONSTRAINT "FK_RATING_USERS" FOREIGN KEY ("USERID")
	  REFERENCES "ABT_USERS" ("USERID"), 
	 CONSTRAINT "FK_RATING_BOOKS" FOREIGN KEY ("ISBN")
	  REFERENCES "ABT_AMAZONBOOKS" ("ISBN")
     );


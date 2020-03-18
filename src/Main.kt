import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

fun main() {
    val c:Connection = DriverManager.getConnection(
        "jdbc:mycq://local",
        "Zilya",
        "123456"
    )

    val s: Statement = c.createStatement()
    val dt1 = "drop table if exists 'students'"
    val dt2= "drop table if exists 'subject'"
    val dt3= "drop table if exists 'progress'"

    s.execute(dt3)
    s.execute(dt2)
    s.execute(dt1)

    val ct1:String = "create table if not exists 'student', (" +
            "id int auto increment primary key, "+
            "name varchar(30) not null, " +
            "surname varchar(30) not null, " +
            "patronymic varchar(30) not null, " +
            "group_num varchar(30) not null, " +
            "birth date not null, " +
            "admission year not null" +
            ");"

    val ct2:String = "create table if not exists 'subject', (" +
            "id int auto increment primary key," +
            "name varchar(50) not null," +
            "semester int not null, " +
            "control enum('Экзамен', 'Дифф.зачёт', 'Звчёт')"+
            "hours int unsigned not null" +
            ");"

    val ct3:String = "create table if not exists 'progress', (" +
            "id int auto increment primary key, "+
            "stud_id int not null," +
            "subj_id int not null," +
            "rating int unsigned not null," +
            "constraint 'stud' foreign key ('stud_id') ref," +
            "constraint 'subj' foreign key ('subj_id') ref," +
            ");"

    s.execute(ct1)
    s.execute(ct2)
    s.execute(ct3)

    val files:List<String> = listOf("student.csv", "subject.csv", "progress.csv")
    for (f:String in files){
        val br = BufferedReader(
            InputStreamReader(
                FileInputStream(f)
            )
        )
        val tb1:String = f.split(".")[0]
        var first = true
        var cols:List<String> = listOf<String>()
        while (br.ready()){
            val l:String = br.readLine()
            if (first && l!=null){
                first = false
                cols = l.split(";")
                continue
            }
            
        }

    }


}
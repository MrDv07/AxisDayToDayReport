class college {
    var collegeName:String = "HCET"
    var collegePlace:String = "JBP"

    fun display(){
        println("$collegeName $collegePlace")
    }

    inner class branch{
        var branchName:String = "CIVIL"
        var branchPlace:String = "JBP"

        fun branchdisplay(){
            println("$branchName $branchPlace")
        }

        inner class Student{
            var studentName:String = "DV"
            var studentPlace:String = "JBP"
            fun studentdisplay(){
                println("$studentName $studentPlace")
            }
        }
    }
}

fun main() {
    var colobj = college()
    colobj.display()
    colobj.branch().branchdisplay()
    colobj.branch().Student().studentdisplay()
}
const express = require ("express");
const mongoose = require("mongoose");
const methodoverride = require("method-override");
const path = require("path");
const app = express();
const PORT = 8080

app.use(express.static(path.join(__dirname,'public')));
app.use(express.urlencoded({extended: true}));
app.use(methodoverride("_method"));

async function main() {
  await mongoose.connect("mongodb://127.0.0.1:27017/music");
}

main().catch((err) => {
  console.log(err);
});

const studentSchema = new mongoose.Schema({
  student_name: String,
  Roll_no: Number,
  WAD_marks: Number,
  DSBDA_marks: Number,
  CNS_marks: Number,
  CC_marks: Number,
  AI_marks: Number,
});

const Studentdetail = mongoose.model("Studentdetail", studentSchema);

app.listen(PORT, () => {
  console.log(`Server is listening on port ${PORT}`);
});

app.get("/",(req,res) => {
  res.sendFile(path.join(__dirname,'form2.html'));
});



app.get("/insert5", async (req, res) => {
    let arr = [
      { student_name: "hello", Roll_no: 1, WAD_marks: 30, DSBDA_marks: 29,CNS_marks: 12,CC_marks:80,AI_marks:90 },
      { student_name: "he", Roll_no: 1, WAD_marks: 30, DSBDA_marks: 29,CNS_marks: 12,CC_marks:80,AI_marks:90 },
      { student_name: "heo", Roll_no: 1, WAD_marks: 30, DSBDA_marks: 29,CNS_marks: 12,CC_marks:80,AI_marks:90 },
      { student_name: "ho", Roll_no: 1, WAD_marks: 30, DSBDA_marks: 29,CNS_marks: 12,CC_marks:80,AI_marks:90 },

      ];
  
    let result = await Studentdetail.insertMany(arr);
    res.send(result);
  });
  
  
  
  app.get("/totalcount", async (req, res) => {
    let allstudents = await Studentdetail.find();
    let count = allstudents.length;
    res.send({ allstudents: allstudents , count: count });
  });




  app.get("/display", async (req, res) => {
    const student = await Studentdetail.find();
  
    let html = "<table border=1 style='border-collapse: collapse'>";
    html =
      html +
      `<tr>
          <th>Student_name</th>
          <th>Roll.no</th>
          <th>WAD marks</th>
          <th>dsbda marks</th>
          <th>cns marks</th>
          <th>cc marks</th>
          <th>AI marks</th>
      </tr>`;
    student.map(function (student) {
      html = html + "<tr>";
      html = html + "<td>" + student.student_name + "</td>";
      html = html + "<td>" + student.Roll_no + "</td>";
      html = html + "<td>" + student.WAD_marks + "</td>";
      html = html + "<td>" + student.DSBDA_marks + "</td>";
      html = html + "<td>" + student.CNS_marks + "</td>";
      html = html + "<td>" + student.CC_marks + "</td>";
      html = html + "<td>" + student.AI_marks + "</td>";
      html = html + "</tr>";
    });
    html = html + "</table>";
    res.send(html);
  });


// // e.  List the names of students who got more than 20 marks in DSBDA Subject in browser.
// app.get("/getMoreThan20InDSBDA", async function (request, response) {
//     const students = await StudentMarks.find({ DSBDA_Marks: { $gt: 20 } }, { Name: 1 }) // 2nd parameter is for displaying only name
//     response.send(students)
// })

// // f.  Update the marks of Specified students by 10.
// app.put("/update10Marks/:studentID", async function (request, response) {
//     const studentID = request.params.studentID
//     const student = await StudentMarks.findOneAndUpdate({ _id: studentID }, { $inc: { WAD_Marks: 10, CC_Marks: 10, DSBDA_Marks: 10, CNS_Marks: 10, AI_Marks: 10 } }, { new: true })
//     response.send(student)
// })

// // g.  List the names who got more than 25 marks in all subjects in browser.
// app.get("/getMoreThan25InAll", async function (request, response) {
//     const students = await StudentMarks.find({
//         WAD_Marks: { $gt: 25 },
//         CC_Marks: { $gt: 25 },
//         DSBDA_Marks: { $gt: 25 },
//         CNS_Marks: { $gt: 25 },
//         AI_Marks: { $gt: 25 }
//     }, { Name: 1 }) // 2nd parameter is for displaying only name

//     // creating view for browser
//     let html = "The List Of Students Name Who Got More Than 25 Marks In All Subjects:"
//     students.map(function (student) {
//         html = html + "<li>"
//         html = html + student.Name
//         html = html + "</li>"
//     })
//     response.send(html)
// })

// // h.  List the names who got less than 40 in both CC and WAD in browser.
// app.get("/getMoreThan40In2Subjects", async function (request, response) {
//     const students = await StudentMarks.find({
//         WAD_Marks: { $gt: 40 },
//         CC_Marks: { $gt: 40 },
//     }, { Name: 1 }) // 3rd parameter is for displaying only name

//     // creating view for browser
//     let html = "The List Of Students Name Who Got More Than 40 Marks In 2 Subjects:"
//     students.map(function (student) {
//         html = html + "<li>"
//         html = html + student.Name
//         html = html + "</li>"
//     })
//     response.send(html)
// })


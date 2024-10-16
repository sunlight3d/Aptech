using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WAD_C1908i_DuongDucAnh.Models;
using PagedList;

namespace WAD_C1908i_DuongDucAnh.Controllers
{
    public class ExamsController : Controller
    {
        private DataContext db = new DataContext();

        // GET: Exams
        public ActionResult Index(string sortOrder, string currentFilter, string searchString, int? page)
        {
            ViewBag.MarkSortParameter = String.IsNullOrEmpty(sortOrder) ? "mark_desc" : "";
            if (searchString != null)
            {
                page = 1;
            }
            else
            {
                searchString = currentFilter;
            }

            ViewBag.CurrentFilter = searchString ?? "";
            
            var students = from student in db.Students
                           select student;
            var exams = from exam in db.Exams select exam;
            var subjects = from subject in db.Subjects select subject;
            var studentJoinExamJoinSubjects = students
                .Join(exams,
                    student => student.StudentId, exam => exam.StudentId,
                        (student, exam) => new { student, exam })
                .Join(subjects,
                    studentJoinExam => studentJoinExam.exam.SubjectId,
                    subject => subject.SubjectId,
                    (studentJoinExam, subject) => new { studentJoinExam, subject }
                )
                .Select(model => new ViewModelStudentExamSubject() {
                    StudentId = model.studentJoinExam.student.StudentId,
                    StudentName = model.studentJoinExam.student.StudentName,
                    SubjectName = model.subject.SubjectName,
                    Mark = model.studentJoinExam.exam.Mark
                   
                });

            if (!String.IsNullOrEmpty(searchString))
            {
                studentJoinExamJoinSubjects = studentJoinExamJoinSubjects
                                            .Where(model => model.StudentName.Contains(searchString)
                                                || model.StudentName.Contains(searchString));
            }
            switch (sortOrder)
            {
                case "mark_desc":
                    studentJoinExamJoinSubjects = studentJoinExamJoinSubjects
                                                    .OrderByDescending(model => model.Mark);
                    break;
                default:
                    studentJoinExamJoinSubjects = studentJoinExamJoinSubjects
                                                    .OrderBy(model => model.StudentName);
                    break;
            }            
            int pageSize = 3;
            int pageNumber = (page ?? 1);
            return View(studentJoinExamJoinSubjects.ToPagedList(pageNumber, pageSize)); 
        }

        // GET: Exams/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Exam exam = db.Exams.Find(id);
            if (exam == null)
            {
                return HttpNotFound();
            }
            return View(exam);
        }

        // GET: Exams/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Exams/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [Authorize]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "StudentId,SubjectId,Mark")] Exam exam)
        {
            if (ModelState.IsValid)
            {
                db.Exams.Add(exam);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(exam);
        }

        // GET: Exams/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Exam exam = db.Exams.Find(id);
            if (exam == null)
            {
                return HttpNotFound();
            }
            return View(exam);
        }

        // POST: Exams/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "StudentId,SubjectId,Mark")] Exam exam)
        {
            if (ModelState.IsValid)
            {
                db.Entry(exam).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(exam);
        }

        // GET: Exams/Delete/5
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Exam exam = db.Exams.Find(id);
            if (exam == null)
            {
                return HttpNotFound();
            }
            return View(exam);
        }

        // POST: Exams/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        [Authorize]
        public ActionResult DeleteConfirmed(int id)
        {
            Exam exam = db.Exams.Find(id);
            db.Exams.Remove(exam);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}

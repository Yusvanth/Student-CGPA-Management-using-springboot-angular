import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students:Observable<Student[]>;
  constructor(private studentService:StudentService, private router:Router ) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.studentService.getStudentList().subscribe(data => {
      this.students = data;
    });}

  deleteStudent(id:number){
    this.studentService.deleteStudent(id).subscribe(
      (data: any)=>{
        console.log(data);
        this.reloadData();
      },
      (error: any)=>console.log(error));
  }
  studentDetails(id:number){
    this.router.navigate(['details',id]);
  }

}

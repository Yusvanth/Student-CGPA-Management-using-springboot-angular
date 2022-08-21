import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8012/Student';

  constructor(private http: HttpClient) { }



  updateStudent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}`, value);
  }
  getStudent(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/get/${id}`);
  }
  createStudent(student: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, student);
  }
  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }
  getStudentList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/list`);
  }

}

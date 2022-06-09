import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { IDoctor } from '../model/iDoctor';
import { IPatient } from '../model/iPatient';

@Injectable({
  providedIn: 'root'
})
export class HospitalserviceService {

  private doctorUrl:string = `http://localhost:9001`;  
  private patientUrl:string = `http://localhost:9002`;  
  constructor(private httpClient:HttpClient) { }

   //error handling
   public handleError(error: HttpErrorResponse) {
    let errorMessage: string = ``;
    if (error.error instanceof ErrorEvent) {
      //client error
      errorMessage = `Error : ${error.error.message}`;
    }
    else {
      //server error
      errorMessage = `status : ${error.status}`;
    }
    return throwError(() => errorMessage);
  }

  //get all Doctor
  public getAllDoctors():Observable<IDoctor[]>{
    let dataUrl:string = `http://localhost:9001/doctors`;
    return this.httpClient.get<IDoctor[]>(dataUrl).pipe(catchError(this.handleError));
  }
   //get Doctor by name
   public getDoctor(name:string):Observable<IDoctor>{
     
    let dataUrl:string = `${this.doctorUrl}/doctors/doctor/${name}`;
    return this.httpClient.get<IDoctor>(dataUrl).pipe(catchError(this.handleError));
  }
  //create doctor
  public createDoctor(Dgroup: IDoctor): Observable<IDoctor> {
    let dataUrl: string = `${this.doctorUrl}/doctors/doctor`;
    return this.httpClient.post<IDoctor>(dataUrl, Dgroup).pipe(catchError(this.handleError));
  }
   //get Patient by id ${this.serverUrl}
   public getPatient(patient_id:number):Observable<IDoctor>{
    let dataUrl:string = `${this.patientUrl}/patients/patient/${patient_id}`;
    return this.httpClient.get<IDoctor>(dataUrl).pipe(catchError(this.handleError));
  }
  //create patient
  public CreatePatient(Pgroup:IPatient): Observable<IPatient> {
    let dataUrl: string = `${this.patientUrl}/patients/patient`;
    return this.httpClient.post<IPatient>(dataUrl, Pgroup).pipe(catchError(this.handleError));
  }

}

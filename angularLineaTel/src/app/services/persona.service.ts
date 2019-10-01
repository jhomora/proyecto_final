import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Persona } from '../model/persona';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private baseUrl = 'http://localhost:8080/api/personas';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient ) {
    console.log('Servicio Funcionando');
  }


  createPersona(persona: Persona): Observable<Persona> {
    return this.http.post<Persona>(this.baseUrl, persona, {headers: this.httpHeaders});
 }

  // getCustomers(): Observable<Customer[]> {
  //   return this.http.get(this.baseUrl).pipe(
  //     map(data => data as Customer[])
  //   );
  // }

  // getCustomer(id: number): Observable<Customer> {
  //   return this.http.get<Customer>(`${this.baseUrl}/${id}`);
  // }


  // updateCustomer(customer: Customer): Observable<Customer> {
  //   return this.http.put<Customer>(this.baseUrl, customer, {headers: this.httpHeaders});
  // }

  // deleteCustomer(id: number): Observable<Customer> {
  //   return this.http.delete<Customer>(`${this.baseUrl}/${id}`, {headers: this.httpHeaders});
  // }
}
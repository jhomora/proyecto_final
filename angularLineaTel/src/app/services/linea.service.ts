import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Linea } from '../model/linea';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LineaService {
  private baseUrl = 'http://localhost:8080/api/lineas';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient ) {
    console.log('Servicio Funcionando');
  }

  getLineas(): Observable<Linea[]> {
    return this.http.get(this.baseUrl).pipe(
      map( data => data as Linea[]) 
    );
  }

  deleteLinea(id: number): Observable<Linea> {
    return this.http.delete<Linea>(`${this.baseUrl}/${id}`, {headers: this.httpHeaders});
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Facturas } from '../model/facturas';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {
  private baseUrl = 'http://localhost:8080/api/facturas';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient ) {
    console.log('Servicio Funcionando');
  }

  traerFacturas(): Observable<Facturas[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data as Facturas[])
    );
  }

  deleteFactura(id: number): Observable<Facturas> {
    return this.http.delete<Facturas>(`${this.baseUrl}/${id}`, {headers: this.httpHeaders});
  }
}

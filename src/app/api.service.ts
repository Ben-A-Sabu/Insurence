import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { jwtDecode } from 'jwt-decode';


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8090/insurance';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders | undefined {
    if (typeof window !== 'undefined') {
      const token = localStorage.getItem('token');
      if (token) {
        return new HttpHeaders({ 'Authorization': 'Bearer ' + token });
      }
    }
    return undefined;
  }

  get(url: string, useToken: boolean = true): Observable<any> {
    const headers = useToken ? this.getAuthHeaders() : undefined;
    return this.http.get(this.baseUrl + url, { headers });
  }

  post(url: string, body: any, useToken: boolean = true): Observable<any> {
    const headers = useToken ? this.getAuthHeaders() : undefined;
    return this.http.post(this.baseUrl + url, body, { headers });
  }

  put(url: string, body: any, useToken: boolean = true): Observable<any> {
    const headers = useToken ? this.getAuthHeaders() : undefined;
    return this.http.put(this.baseUrl + url, body, { headers });
  }

  delete(url: string, useToken: boolean = true): Observable<any> {
    const headers = useToken ? this.getAuthHeaders() : undefined;
    return this.http.delete(this.baseUrl + url, { headers });
  }
}
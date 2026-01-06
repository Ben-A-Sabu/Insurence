import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import { parseJwt } from '../jwt-parser';


@Component({
  selector: 'app-login-component',
  standalone:false,
  templateUrl: './login-component.html',
  styleUrls: ['./login-component.css']
})
export class LoginComponent {
  email = '';
  password = '';

  constructor(private api: ApiService, private router: Router) {}
  ngOnInit(): void {
    if(typeof window!==undefined){
    const token=localStorage.getItem('token');
    if(token){
      this.router.navigate(['/dashboard']);
    }
  }
  }
  login() {
    this.api.post('/insurer/login', { email: this.email, password: this.password }, false)
      .subscribe({
        next: (res: any) => {
          const token = res.token;
          localStorage.setItem('token', res.token);
          const data = parseJwt(res.token);
          if (data) {
            this.email = data.sub;
            localStorage.setItem('email', this.email);
          }
          this.router.navigate(['/dashboard']);
        },
        error: (err) => {
          alert('Login failed');
          console.error(err);
        }
      });
  }
}
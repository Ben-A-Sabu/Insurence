import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Insurance');
  // ngOnInit(): void {
  //  localStorage.removeItem('token');
  //  localStorage.removeItem('email');
  // }
}

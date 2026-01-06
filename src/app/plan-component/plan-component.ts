import { ChangeDetectorRef, Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-plan-component',
  standalone: false,
  templateUrl: './plan-component.html',
  styleUrl: './plan-component.css',
})
export class PlanComponent {
  public plan: any[]=[];
  plans={
    planName:'',
    premium:'',
    duration:'',
  }
  constructor(private api:ApiService,private cdr: ChangeDetectorRef,private router: Router){}
  goBack(){
    this.router.navigate(['/dashboard']);
  }
  ngOnInit() {
    this.loadPlans();
    console.log(this.plan);
  }
  loadPlans(){
    this.api.get('/insurer/plan').subscribe((res:any)=>{
      console.log("Pans from backed:", res);
      this.plan=res;
      this.cdr.markForCheck();
    }
  );
  }
  createPlan():void{
    console.log("Creating Plan: ",this.plans);
    this.api.post('/insurer/plan',this.plans,true).subscribe({
      next:()=>{
        alert('plan creted');
        this.resetForm();
        this.loadPlans();
      },
      error: err=>{
        console.error('Create plan error', err);
        alert('failed to create plan');
      }
    })
  }
  activate(id:number){
    this.api.put(`/insurer/plan/${id}/activate`,{},true).subscribe(()=>this.loadPlans());
  }
  deactivate(id:number){
    this.api.put(`/insurer/plan/${id}/deactivate`,{},true).subscribe(()=>this.loadPlans());
  }
  resetForm():void{
    this.plans={
      planName:'',
      premium:'',
      duration:''
    }
  }
}

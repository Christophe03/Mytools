
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginServiceService } from './loginService/login-service.service';


@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.scss']
})
export class LoginpageComponent implements OnInit {

  successMessage:string ="";
  loginForm!: FormGroup; 
  user: any;
  
   constructor(private fb: FormBuilder, private loginServiceService:LoginServiceService,private router :Router) { }


  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email:['',[Validators.required, Validators.pattern("[A-Za-z0-9]*@gmail.com")]],
      password:['',[Validators.required,Validators.pattern("[A-Za-z0-9@!_]{8,}")]]
    })
  }

  login(){
      
    this.user = this.loginForm.value;
    console.log("bonjour", this.user);
    this.successMessage="Successfully Loggined In..."
    this.loginServiceService.login(this.user.email, this.user.password).subscribe((data:any)=>{
      console.log("login...", data);
      if(data!=null){  
        localStorage.setItem("current_user", JSON.stringify(data));
        this.router.navigateByUrl("/tableau")
      }
    });
  }

}





import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot,  Router, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthentificationService } from './authentification.service';
@Injectable({
  providedIn: 'root'
})
export class AuthentificationGuard implements CanActivate {
  constructor(private router: Router){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      let loginStatus = localStorage.getItem("current_user");
      if(loginStatus != null)
      {
        // this.router.navigate(['/login']);
        return true;
      }
      return this.router.navigate(['/login']);

      // return false;
  }
  // constructor(private authenticationService:AuthentificationService, private router:Router){}
  // canActivate(
  //   route: ActivatedRouteSnapshot,
  //   state: RouterStateSnapshot): boolean {
  //   return this.isUserLoggedIn();
  // }
  // private isUserLoggedIn(): boolean {
  //   if(this.authenticationService.isUserloggedIn()){

  //     return true;

  //   } else {
  //     this.router.navigate(['/login'])
  //     return false;
  //   }
    
    
  // }
  
  
}

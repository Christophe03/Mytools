import { AtelierService } from './../Service/atelier.service';
import { Component,ViewChild, ViewContainerRef, ComponentRef, ComponentFactoryResolver, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AngularNotificationService, NotifComponent } from 'angular-notification-alert';
import  Swal  from 'sweetalert2'
@Component({
  selector: 'app-atelier',
  templateUrl: './atelier.component.html',
  styleUrls: ['./atelier.component.scss']
})
export class AtelierComponent implements OnInit {
  mode=1
  list:any
  getAcce: any;
  @ViewChild('parent', {read: ViewContainerRef}) target: ViewContainerRef;
  private componentRef : ComponentRef<any>;
  constructor(
    private atelierservice :AtelierService,
    private angAlert : AngularNotificationService,
    private componentFactoryResolver : ComponentFactoryResolver
  ) { }

  ngOnInit(): void {
    this.atelierservice.listeAtelier().subscribe((data:any)=>{
      this.list = data;
      // console.log("bonjour",data)
    })
  }

  test(){
    this.mode=2;
  }
  
  test1(){
    window.location.reload()
    this.mode=1;
  }
  edit(){
    this.mode=3;

  }
  details(){
    this.mode=4;


  }
  deleteitem(id: any) {
    Swal.fire({
      title: 'Êtes-vous sûr?',
      text: "Vous ne pourrez pas revenir en arrière!",
      icon: 'warning',
      showCancelButton: true,
      cancelButtonText:'Annuler',
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Oui, supprimez-le!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.atelierservice.supprimerAtelier(id).subscribe(res=>{
        Swal.fire(
          'Supprimer!',
          'Votre fichier a été supprimé.',
          'success'
        )
      }
    )
    window.location.reload()
  }
      
    })
}
saveAcc(f:NgForm){
  window.location.reload()
  // console.log("hello", f.value);
  this.atelierservice.ajouterAtelier(f.value).subscribe((data:any)=>{
    // console.log("save...", data);
    
  });
  
}
toEdit(event:any){
  console.log("event", event);
  this.atelierservice.afficherAtelierById(event).subscribe((data:any)=>{
    // console.log("get atelier", data);
    this.getAcce = data
    this.edit();

    
  });

  
}
savemodif(abba: NgForm){ 
  // console.log("morning", abba.value);
  // console.log(abba.value);  
  
  this.atelierservice.modifierAtelier(abba.value, this.getAcce.id).subscribe((data: any) =>{ 
    // this.alertAngular();
    console.log("save...", data);
  })
}

alertAngular(){
  let setting = {
    with:'300px',
    position:'center',
    type:'#107B97',
    title:'Notification',
    body:'Modification reussie',
    background:'#fff',
  };
  this.angAlert.setProperties(setting);
  const childComponent  = this.componentFactoryResolver.resolveComponentFactory( NotifComponent );
  this.componentRef = this.target.createComponent(childComponent);
  window.location.reload()
  // console.log("Lol");
  
}
toDetail(event:any){
  this.mode=4;
  // console.log("event", event);
  this.atelierservice.afficherAtelierById(event).subscribe((data:any)=>{
    // console.log("get vente", data);
    this.getAcce = data
    this.details
    
   
    
  });
}
}


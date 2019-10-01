import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router'
import { PersonaService } from "../../services/persona.service";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-persona',
  templateUrl: './add-persona.component.html',
  styles: []
})
export class AddPersonaComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private service: PersonaService) { }

  agregar: FormGroup;

  ngOnInit() {
    this.agregar = this.formBuilder.group({
      id: [],
      documento: ['', Validators.required],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      telefono_fijo: ['', Validators.required],
      fecha_nacimiento: ['', Validators.required],
      celular: ['', Validators.required]
    });
  }

  onSubmit() {
    this.service.createPersona( this.agregar.value )
      .subscribe(data => {
        this.router.navigate(['index']);
        Swal.fire({
          position: 'top',
          type: 'success',
          title: `Cliente creado con éxito`,
          showConfirmButton: false,
          timer: 1500
        });
      });
  }

}


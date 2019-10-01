import { Component, OnInit } from '@angular/core';
import { Linea } from '../../model/linea';
import { LineaService } from '../../services/linea.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  linea: Linea[];

  constructor(private router: Router, private service: LineaService) {}

  ngOnInit() {
    this.service.getLineas().subscribe(data => (this.linea = data));
  }

  deleteLinea(linea: Linea): void {
    Swal.fire({
      title: 'Está seguro?',
      text: `¿Seguro desea eliminar la linea con el numero ${linea.estado}`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'Cancelar'
    }).then(result => {
      if (result.value) {
        this.service.deleteLinea(linea.id).subscribe(data => {
          this.linea = this.linea.filter(c => c !== linea);
        });

        Swal.fire('Eliminado!', 'Se ha eliminado la linea.', 'success');
      }
    });
  }
}

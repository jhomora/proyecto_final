import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FacturaService } from '../../services/factura.service';
import Swal from 'sweetalert2';
import { Facturas } from 'src/app/model/facturas';

@Component({
  selector: 'app-consult-facturas',
  templateUrl: './consult-facturas.component.html',
  styles: []
})
export class ConsultFacturasComponent implements OnInit {

  factura: Facturas[];

  constructor(private router: Router, private service: FacturaService) {}

  ngOnInit() {
    this.service.traerFacturas().subscribe(data => (this.factura = data));
  }

  deleteFactura(factura: Facturas): void {
    Swal.fire({
      title: 'Está seguro?',
      text: `¿Seguro desea eliminar la factura de el numero ${factura.num_lin_fac}`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'Cancelar'
    }).then(result => {
      if (result.value) {
        this.service.deleteFactura(factura.id_factura).subscribe(data => {
          this.factura = this.factura.filter(c => c !== factura);
        });

        Swal.fire('Eliminado!', 'Se ha eliminado la factura.', 'success');
      }
    });
  }

}

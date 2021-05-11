import { Component } from '@angular/core';
import { Sensor } from "../../model/sensor.model";
import { SensorsRepository } from "../../model/repository/sensors.repository";

@Component({
  selector: 'sensors-detail',
  templateUrl: './sensors-detail.component.html'
})
export class SensorsDetailComponent {

  constructor(private repository: SensorsRepository) {}

  get sensors(): Sensor[] {
    return this.repository.getSensors();
  }
}

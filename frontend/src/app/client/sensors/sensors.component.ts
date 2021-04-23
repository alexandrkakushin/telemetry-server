import {Component} from '@angular/core';
import {Sensor} from "../../model/sensor.model";
import {SensorsRepository} from "../../model/repository/sensors.repository";

@Component({
  selector: 'sensors-root',
  templateUrl: './sensors.component.html'
})
export class SensorsComponent {

  constructor(private repository: SensorsRepository) {}

  get sensors(): Sensor[] {
    return this.repository.getSensors();
  }
}

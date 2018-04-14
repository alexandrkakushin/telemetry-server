import {ChangeDetectionStrategy, Component} from '@angular/core';
import {Sensor} from "../model/sensor.model";
import {SensorsRepository} from "../model/sensors.repository";

@Component({
  selector: 'sensors-root',
  moduleId: module.id,
  templateUrl: './sensors.component.html'
  //changeDetection: ChangeDetectionStrategy.OnPush
})
export class SensorsComponent {

  constructor(private repository: SensorsRepository) {}

  get sensors(): Sensor[] {
    return this.repository.getSensors();
  }
}

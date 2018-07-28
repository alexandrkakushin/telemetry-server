
import { NgModule } from "@angular/core";
import {OsRepository} from "./repository/os.repository";
import {FileSystemsRepository} from "./repository/filesystems.repository";
import {SensorsRepository} from "./repository/sensors.repository";
import {RestDataSource} from "./repository/rest.datasource";
import {HttpClientModule} from "@angular/common/http";
import {CpuRepository} from "./repository/cpu.repository";

@NgModule({
  imports: [HttpClientModule],
  providers: [
    CpuRepository,
    FileSystemsRepository,
    SensorsRepository,
    OsRepository,
    RestDataSource
    ]
})

export class ModelModule {}

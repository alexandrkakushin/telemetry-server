
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { ModelModule } from "../model/model.module";
import { OsComponent } from "./os.component";
import { FileSystemsComponent } from "./filesystems.component";
import { SensorsComponent } from "./sensors.component";

@NgModule({
  imports: [ModelModule, BrowserModule],
  declarations: [OsComponent, FileSystemsComponent, SensorsComponent],
  exports: [OsComponent, FileSystemsComponent, SensorsComponent]
})

export class ClientModule {}

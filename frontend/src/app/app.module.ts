import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module'
import { ComponentsModule } from './components/components.module';
import { CpuPageComponent } from './pages/cpu/cpu-page.component';
import { HomePageComponent } from './pages/home/home-page.component';
import { SensorsPageComponent } from './pages/sensors/sensors-page.component';
import { FileSystemsPageComponent } from './pages/filesystems/filesystems-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CpuPageComponent,
    SensorsPageComponent,
    FileSystemsPageComponent
  ],
  imports: [
    ComponentsModule,
    BrowserModule, 
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }

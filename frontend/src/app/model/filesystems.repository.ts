
import {Injectable} from "@angular/core";
import {FileSystem} from "./filesystem.model";
import {StaticDataSource} from "./static.datasource";

@Injectable()
export class FileSystemsRepository {

  private fileSystems: FileSystem[] = [];

  constructor(private dataSource: StaticDataSource) {
    this.dataSource.getFileSystems().subscribe(
      data => {
        this.fileSystems = data;
      }
    );
  }

  getFileSystems(): FileSystem[] {
    return this.fileSystems;
  }
}

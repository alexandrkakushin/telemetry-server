export class Os {

  arch: string;
  type: string;
  version: string;

  constructor(arch: string, type: string, version: string) {
    this.arch = arch;
    this.type = type;
    this.version = version;    
  }

  static assign(item: any): Os {
    return new Os(
      item.arch,
      item.type,
      item.version
    )
  }  
}
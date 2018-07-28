
export class Cpu {

  constructor(public load?: number) {}

  static assign(item: any): Cpu {
    return new Cpu(
      item.load
    );
  }
}

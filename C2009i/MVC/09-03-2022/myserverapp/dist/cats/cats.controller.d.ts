import { CreateCatDto } from './dtos/create.cat.dto';
export declare class CatsController {
    doSomething(createCatDto: CreateCatDto): Promise<any[]>;
    getDocs(version: any, x: any, y: any): {
        url: string;
    };
    create(): string;
}

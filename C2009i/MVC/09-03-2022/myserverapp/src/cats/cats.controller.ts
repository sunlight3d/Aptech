import { 
    Controller, 
    HttpCode,
    Get, 
    Post,
    Redirect, 
    Query,
    Body,
} from '@nestjs/common';
import { CreateCatDto } from './dtos/create.cat.dto';
@Controller('cats')
//annotation
export class CatsController {    
    //http://localhost:3001/cats/doSomething
    @Post("doSomething")
    async doSomething(        
        @Body() createCatDto: CreateCatDto): Promise<any []> {
        const {name, age, breed} = createCatDto
        console.log(`name = ${name}, age = ${age}, breed = ${breed}`)
     return [{
         'result': 'ok',
         message: 'haha'
     }]   
    }

    @Get('ab*cd')
    @HttpCode(204)
    @Redirect('https://nestjs.com', 301)
    //version=123
    getDocs(@Query('version') version, @Query('x') x, @Query('y') y) {
        console.log('kaka version: '+JSON.stringify(version))
        console.log(`y = ${parseInt(y)}`)
        if (version && version === '5') {
          return { url: 'https://docs.nestjs.com/v5/' };
        }
    }
      
    /*
    findAll(): string {
      return 'This action returns all cats';
    }
    */
    @Post()
    create(): string {
        return 'This action adds a new cat';
    }
}

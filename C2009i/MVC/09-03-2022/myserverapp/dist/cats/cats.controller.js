"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.CatsController = void 0;
const common_1 = require("@nestjs/common");
const create_cat_dto_1 = require("./dtos/create.cat.dto");
let CatsController = class CatsController {
    async doSomething(createCatDto) {
        const { name, age, breed } = createCatDto;
        console.log(`name = ${name}, age = ${age}, breed = ${breed}`);
        return [{
                'result': 'ok',
                message: 'haha'
            }];
    }
    getDocs(version, x, y) {
        console.log('kaka version: ' + JSON.stringify(version));
        console.log(`y = ${parseInt(y)}`);
        if (version && version === '5') {
            return { url: 'https://docs.nestjs.com/v5/' };
        }
    }
    create() {
        return 'This action adds a new cat';
    }
};
__decorate([
    (0, common_1.Post)("doSomething"),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [create_cat_dto_1.CreateCatDto]),
    __metadata("design:returntype", Promise)
], CatsController.prototype, "doSomething", null);
__decorate([
    (0, common_1.Get)('ab*cd'),
    (0, common_1.HttpCode)(204),
    (0, common_1.Redirect)('https://nestjs.com', 301),
    __param(0, (0, common_1.Query)('version')),
    __param(1, (0, common_1.Query)('x')),
    __param(2, (0, common_1.Query)('y')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object, Object, Object]),
    __metadata("design:returntype", void 0)
], CatsController.prototype, "getDocs", null);
__decorate([
    (0, common_1.Post)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", String)
], CatsController.prototype, "create", null);
CatsController = __decorate([
    (0, common_1.Controller)('cats')
], CatsController);
exports.CatsController = CatsController;
//# sourceMappingURL=cats.controller.js.map
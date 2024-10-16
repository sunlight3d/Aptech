import { Language } from './Language.model';
export interface Student {
    name: string;
    dob:Date;
    gender: string
    languages: Language[]
    klass: string    
}
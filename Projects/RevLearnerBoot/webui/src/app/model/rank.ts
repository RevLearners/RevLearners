import { Topic } from './topic';

export class Rank {
    id: number;
    merit_threshhold: number;
    name: string;
    heirarchy_rank: number;
    topic: Topic = null; 

    constructor(id: number, merit_threshhold: number, name: string,
                  heirarchy_rank: number, topic: Topic) {
        this.id = id;
        this.merit_threshhold = merit_threshhold;
        this.name = name;
        this.heirarchy_rank = heirarchy_rank;
        this.topic = topic;
    }
}
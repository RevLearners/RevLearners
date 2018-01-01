import { Topic } from './topic';

export class Rank {
    id: number;
    meritThreshold: number;
    rankName: string;
    relativeWeight: number;
    topic: Topic = null;

    constructor(id: number, merit_threshhold: number, rankName: string,
                  heirarchy_rank: number, topic: Topic) {
        this.id = id;
        this.meritThreshold = merit_threshhold;
        this.rankName = rankName;
        this.relativeWeight = heirarchy_rank;
        this.topic = topic;
    }
}

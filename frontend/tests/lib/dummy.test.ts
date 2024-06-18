import {describe, expect, it, vi} from 'vitest';
import {DummyClass} from '../../src/lib/dummy'

describe('dummy', () => {

    it('should xxx', () => {
        const dummy = new DummyClass()
        expect(dummy.getValue()).toBe("dummy")
    })
})
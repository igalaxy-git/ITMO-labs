#!/usr/bin/env python
# coding=utf-8
import sys
import inkex
from lxml import etree
def draw_SVG_ornament(a,x,y,cur):
    style = {'stroke': '#000000', 'stroke-width': str(x/6), 'fill': 'none'}
    elem = cur.add(inkex.PathElement())
    elem.update(**{
        'style': style,
        'inkscape:label': 'MyOrnament',
         'd': ' '.join(['M ' + str(i*x/2 + x/4) + ',' + str(y/3) +
              ' L ' + str(i*x/2 + x/4) + ',' + str(y*2/3) for i in range(int(a)*2)])})
    style = {'stroke': '#000000', 'stroke-width': '2', 'fill': 'none'}
    elem1 = cur.add(inkex.PathElement())
    elem1.update(**{
        'style': style,
        'inkscape:label': 'MyOrnament',
         'd': 'M ' + str(0) + ',' + str(0) +
              ''.join([' L ' + str(i*x) + ',' + str(y) +
              ' L ' + str(i*x + x/2) + ',' + str(y) +
              ' L ' + str(i*x + x/2) + ',' + str(0) +
              ' L ' + str((1+i) * x) + ',' + str(0) +
              ' L ' + str((1+i) * x) + ',' + str(y) for i in range(int(a))])})
    return elem, elem1

class MySquare(inkex.EffectExtension):
    def add_arguments(self, pars):
        pars.add_argument("--s_l", type=float, default=10.0, help="Width")
        pars.add_argument("--s_h", type=float, default=10.0, help="Height")
        pars.add_argument("--am", type=int, default=1, help="Amount")
    def effect(self):
        cur = self.svg.get_current_layer()å
        x = self.options.s_l
        y = self.options.s_h
        a = self.options.am
        draw_SVG_ornament(a,x,y,cur) 
if __name__ == '__main__':
    MySquare().run()

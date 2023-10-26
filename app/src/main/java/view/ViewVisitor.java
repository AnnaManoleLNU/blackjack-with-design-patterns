package view;

/**
 * Implements a visitor pattern for the views.
 */
public interface ViewVisitor {
  void visit(EnglishView view);
  
  void visit(SwedishView view);
}
